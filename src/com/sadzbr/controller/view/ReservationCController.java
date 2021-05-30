package com.sadzbr.controller.view;

import com.sadzbr.controller.DataFlowController;
import com.sadzbr.controller.SceneController;
import com.sadzbr.model.*;
import com.sadzbr.model.Package;
import com.sadzbr.service.LoggedUser;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.TableUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class ReservationCController implements Initializable {

    @FXML private Text payAmount;
    @FXML private Text hotelAddress;
    @FXML private Text hotelName;
    @FXML private TextArea summary;
    @FXML private ChoiceBox<String> paymentMethod;
    private double paySum;


    public void handleChangeButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationB");
    }

    public void makeSummary() {
        String result = "";
        DataFlowController dataFlowController = DataFlowController.getInstance();

        result = result + "Liczba osób: " + dataFlowController.getValue("numberOfPersons") + "\n";
        result = result + "Pakiet: " + dataFlowController.getValue("packageName") + "\n";
        result = result + "Pokój: " + dataFlowController.getValue("roomNr") + "\n";
        result = result + "Data przyjazdu: " + dataFlowController.getValue("dateArrival") + "\n";
        result = result + "Data odjazdu: " + dataFlowController.getValue("dateDeparture") + "\n";
        result = result + "Imię: " + dataFlowController.getValue("name") + "\n";
        result = result + "Nazwisko: " + dataFlowController.getValue("surname") + "\n";
        result = result + "Miasto: " + dataFlowController.getValue("city") + "\n";
        result = result + "Kod pocztowy: " + dataFlowController.getValue("postCode") + "\n";
        result = result + "Ulica: " + dataFlowController.getValue("street") + "\n";
        result = result + "Nr. domu: " + dataFlowController.getValue("homeNr") + "\n";
        result = result + "Nr. mieszkania: " + dataFlowController.getValue("flatNr") + "\n";

        paySum = 0.0;

        TableUtil<Package> packageTableUtil = new TableUtil<>(Package::new);
        Package p = packageTableUtil.getByID(packageTableUtil.getList(), Integer.parseInt(dataFlowController.getValue("package")));
        paySum += p.getPrice();

        TableUtil<Rooms> roomsTableUtil = new TableUtil<>(Rooms::new);
        Rooms rooms = roomsTableUtil.getByID(roomsTableUtil.getList(), Integer.parseInt(dataFlowController.getValue("roomID")));
        paySum += rooms.getPrice();

        summary.setText(result);
        payAmount.setText("Kwota do zapłaty: " + paySum);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        summary.setEditable(false);
    }

    public void userHasLogged() {
        LoggedUser loggedUser = LoggedUser.getINSTANCE();
        Hotel hotel  = HotelUtil.getByID(HotelUtil.getHotelList(),loggedUser.getUser().getId_hotel());
        assert hotel != null : "Hotel is null";
        hotelName.setText(hotel.getName());
        hotelAddress.setText(hotel.getAddress());
    }

    public void handleConfirmButton(ActionEvent actionEvent) {
        DataFlowController dataFlowController = DataFlowController.getInstance();

        TableUtil<Payments> paymentsTableUtil = new TableUtil<>(Payments::new);
        TableUtil<Client> clientTableUtil = new TableUtil<>(Client::new);
        TableUtil<Reservations> reservationsTableUtil = new TableUtil<>(Reservations::new);

        /* ADDING PAYMENT */
        Payments payments = new Payments();
        payments.setForm(paymentMethod.getValue());
        payments.setAmount(paySum);
        payments = paymentsTableUtil.insertList(payments);
        assert payments != null;

        /* ADDING CLIENT */
        Client client = new Client();
        client.setName(dataFlowController.getValue("name"));
        client.setSurname(dataFlowController.getValue("surname"));
        client.setStreet(dataFlowController.getValue("street"));
        client.setHome_nr(Integer.parseInt(dataFlowController.getValue("homeNr")));
        int flat_nr;
        if(dataFlowController.getValue("flatNr").isEmpty()) {
            flat_nr = 0;
        } else {
            flat_nr = Integer.parseInt(dataFlowController.getValue("flatNr"));
        }
        client.setFlat_nr(flat_nr);
        client.setZip_code(dataFlowController.getValue("postCode"));
        client.setCity(dataFlowController.getValue("city"));
        client = clientTableUtil.insertList(client);
        assert client != null;

        /* ADDING NEWSLETTER */
        if(Boolean.parseBoolean(dataFlowController.getValue("newsletter"))) {
            TableUtil<Newsletter> newsletterTableUtil = new TableUtil<>(Newsletter::new);

            Newsletter newsletter = new Newsletter();
            newsletter.setEmail(dataFlowController.getValue("email"));
            newsletter.setId_client(client.getId());

            newsletterTableUtil.insertList(newsletter);
        }

        /* ADDING RESERVATION */
        Reservations reservations = new Reservations();
        reservations.setId_room(Integer.parseInt(dataFlowController.getValue("roomID")));
        reservations.setId_package(Integer.parseInt(dataFlowController.getValue("package")));
        reservations.setId_payment(payments.getId());
        reservations.setId_client(client.getId());
        try {
            reservations.setDate_start(new SimpleDateFormat("yyyy-MM-dd").parse(dataFlowController.getValue("dateArrival")));
            reservations.setDate_end(new SimpleDateFormat("yyyy-MM-dd").parse(dataFlowController.getValue("dateDeparture")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reservationsTableUtil.insertList(reservations);

        /* CHANGE SCENE */
        SceneController sceneController = SceneController.getInstance();
        ReservationAController reservationAController = sceneController.getLoader("worker/reservationA").getController();
        reservationAController.clearScene();
        sceneController.activate("worker/reservationA");
    }
}
