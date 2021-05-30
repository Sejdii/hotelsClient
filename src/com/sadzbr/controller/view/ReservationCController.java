package com.sadzbr.controller.view;

import com.sadzbr.controller.DataFlowController;
import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Payments;
import com.sadzbr.model.Rooms;
import com.sadzbr.service.LoggedUser;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.TableUtil;
import com.sadzbr.model.Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationCController implements Initializable {

    @FXML private Text payAmount;
    @FXML private Text hotelAddress;
    @FXML private Text hotelName;
    @FXML private TextArea summary;
    @FXML private ChoiceBox<String> paymentMethod;


    public void handleChangeButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationB");
    }

    public void makeSummary() {
        String result = "";
        DataFlowController dataFlowController = DataFlowController.getInstance();

        result = result + "Liczba osób: " + dataFlowController.getValue("numberOfPersons") + "\n";
        result = result + "Pakiet: " + dataFlowController.getValue("package") + "\n";
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

        double paySum = 0.0;

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
        TableUtil<Payments> paymentsTableUtil = new TableUtil<>(Payments::new);

        Payments payments = new Payments();
        payments.setForm(paymentMethod.getValue());
        payments.setAmount(Double.parseDouble(payAmount.getText()));
        payments = paymentsTableUtil.insertList(payments);


    }
}
