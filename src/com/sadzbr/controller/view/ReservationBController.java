package com.sadzbr.controller.view;

import com.sadzbr.controller.DataFlowController;
import com.sadzbr.controller.ErrorController;
import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Rooms;
import com.sadzbr.model.Table;
import com.sadzbr.service.LoggedUser;
import com.sadzbr.utils.Validator;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.ReservationsUtil;
import com.sadzbr.utils.model.RoomsUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Kontroler dla sceny B rezerwacji
 */
public class ReservationBController implements Initializable {
    @FXML private Text hotelAddress;
    @FXML private Text hotelName;
    @FXML private CheckBox newsletter;
    @FXML private ComboBox<Rooms> roomChoose;
    @FXML private Text errorHandler;
    @FXML private TextField flatNr;
    @FXML private TextField homeNr;
    @FXML private TextField street;
    @FXML private TextField postCode;
    @FXML private TextField city;
    @FXML private TextField surname;
    @FXML private TextField name;
    @FXML private TextField email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // listener for number input
        flatNr.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    flatNr.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // listener for number input
        homeNr.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    homeNr.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    /**
     * Wywołuje się gdy zostanie naciśnięty przycisk powrotu
     * @param actionEvent Event
     */
    public void handleReturnButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationA");
    }

    /**
     * Wywołuje się gdy zostanie naciśnięty przycisk rezerwacji
     * @param actionEvent Event
     */
    public void handleReservationButton(ActionEvent actionEvent) {
        //Validation
        ErrorController errorController = ErrorController.getInstance();
        Validator.email(email.getText());
        Validator.charsOnly(name.getText());
        Validator.charsOnly(surname.getText());
        Validator.charsOnly(city.getText());
        Validator.postCode(postCode.getText());
        Validator.charsOnly(street.getText());
        if(Validator.isNotEmpty(homeNr.getText())) {
            Validator.positiveNumber(Integer.parseInt(homeNr.getText()));
        }
        if(!flatNr.getText().isEmpty()) {
            Validator.positiveNumber(Integer.parseInt(flatNr.getText()));
        }
        if(roomChoose.getValue() == null) {
            errorController.addMessage("Żaden pokój nie został wybrany");
        }

        if(errorController.isEmpty()) {
            // everything is okey we can go to next scene
            // sending data to another scenes
            DataFlowController dataFlowController = DataFlowController.getInstance();
            dataFlowController.addValue("email", email.getText());
            dataFlowController.addValue("roomID", String.valueOf(roomChoose.getValue().getId()));
            dataFlowController.addValue("roomNr", String.valueOf(roomChoose.getValue().getRoom_nr()));
            dataFlowController.addValue("newsletter", Boolean.toString(newsletter.isSelected()));
            dataFlowController.addValue("name", name.getText());
            dataFlowController.addValue("surname", surname.getText());
            dataFlowController.addValue("city", city.getText());
            dataFlowController.addValue("postCode", postCode.getText());
            dataFlowController.addValue("street", street.getText());
            dataFlowController.addValue("homeNr", homeNr.getText());
            dataFlowController.addValue("flatNr", flatNr.getText());

            SceneController sceneController = SceneController.getInstance();
            FXMLLoader fxmlLoader = sceneController.getLoader("worker/reservationC");
            ReservationCController reservationCController = fxmlLoader.getController();
            reservationCController.makeSummary(); // send signal to ReservationC to make a summary
            reservationCController.userHasLogged();

            sceneController.activate("worker/reservationC");
            errorHandler.setText("");
        } else {
            errorHandler.setText(errorController.getAllMessages());
        }
    }

    /**
     * Wykonuje się gdy wysłany zostanie sygnał że są dostępne pokoje. Pobiera listę dostępnych pokoi i ustawia combobox
     */
    public void roomsAreAvailable() {
        DataFlowController dataFlowController = DataFlowController.getInstance();
        int numberOfPersons = Integer.parseInt(dataFlowController.getValue("numberOfPersons"));
        Date dateArrival;
        Date dateDeparture;
        try {
            dateArrival = new SimpleDateFormat("yyyy-MM-dd").parse(dataFlowController.getValue("dateArrival"));
            dateDeparture = new SimpleDateFormat("yyyy-MM-dd").parse(dataFlowController.getValue("dateDeparture"));

            List<Table> tableList = ReservationsUtil.getAvailabilityRoomsList(numberOfPersons, dateArrival, dateDeparture);
            roomChoose = RoomsUtil.setCombobox(roomChoose, tableList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wykonuje się gdy zostanie wysłany sygnał że użytkownik się zalogował i jest pracownik.
     */
    public void userHasLogged() {
        LoggedUser loggedUser = LoggedUser.getINSTANCE();
        Hotel hotel  = HotelUtil.getByID(HotelUtil.getHotelList(),loggedUser.getUser().getId_hotel());
        assert hotel != null : "Hotel is null";
        hotelName.setText(hotel.getName());
        hotelAddress.setText(hotel.getAddress());
    }

    /**
     * Czyści pola input sceny
     */
    public void clearScene() {
        newsletter.setSelected(false);
        flatNr.setText("");
        homeNr.setText("");
        street.setText("");
        postCode.setText("");
        city.setText("");
        name.setText("");
        surname.setText("");
        email.setText("");
    }
}
