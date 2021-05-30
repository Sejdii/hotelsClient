package com.sadzbr.controller.view;

import com.sadzbr.controller.DataFlowController;
import com.sadzbr.controller.ErrorController;
import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Package;
import com.sadzbr.service.LoggedUser;
import com.sadzbr.utils.Validator;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.PackageUtil;
import com.sadzbr.utils.model.ReservationsUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReservationAController implements Initializable {
    @FXML private Text hotelAddress;
    @FXML private Text hotelName;
    @FXML private Text errorHandler;
    @FXML private DatePicker dateDeparture;
    @FXML private DatePicker dateArrival;
    @FXML private TextField numberOfPersons;
    @FXML private ComboBox<Package> packageChoose;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // listener for number input
        numberOfPersons.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    numberOfPersons.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // setting day limit for dateArrival and default value
        dateArrival.setValue(LocalDate.now());
        dateArrival.setDayCellFactory(d -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(item.isBefore(LocalDate.now()));
            }
        });

        // setting day limit for dateDeparture
        dateDeparture.setDayCellFactory(d -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(item.isBefore(LocalDate.now()));
            }
        });
    }

    public void handleCheckAvailability(ActionEvent actionEvent) {
        //Validation
        ErrorController errorController = ErrorController.getInstance();
        Validator.reservationDates(dateArrival.getValue(), dateDeparture.getValue());
        if(numberOfPersons.getText().equals("")) { // if TextField numberOfPersons is empty set to 0
            numberOfPersons.setText("0");
        }
        Validator.numberOfPersons(Integer.parseInt(numberOfPersons.getText()));

        if(errorController.isEmpty()) { // inputs are okey, we can check availability
            boolean isAvailable = ReservationsUtil.checkAvailability(Integer.parseInt(numberOfPersons.getText()), ReservationsUtil.convertDateFromLocal(dateArrival.getValue()), ReservationsUtil.convertDateFromLocal(dateDeparture.getValue()));
            if(!isAvailable) {
                errorController.addMessage("Brak dostępnych pokoi dla podanych danych");
            }
        }

        if(errorController.isEmpty()) {
            // everything is okey we can go to next scene
            // sending data to another scenes
            DataFlowController dataFlowController = DataFlowController.getInstance();
            dataFlowController.addValue("numberOfPersons", numberOfPersons.getText());
            dataFlowController.addValue("package", String.valueOf(packageChoose.getValue().getId()));
            dataFlowController.addValue("packageName", String.valueOf(packageChoose.getValue().getName()));
            dataFlowController.addValue("dateArrival", dateArrival.getValue().toString());
            dataFlowController.addValue("dateDeparture", dateDeparture.getValue().toString());


            SceneController sceneController = SceneController.getInstance();

            FXMLLoader fxmlLoader = sceneController.getLoader("worker/reservationB");
            ReservationBController reservationBController = fxmlLoader.getController();
            reservationBController.userHasLogged();
            reservationBController.roomsAreAvailable();

            sceneController.activate("worker/reservationB");
            errorHandler.setText("");
        } else {
            errorHandler.setText(errorController.getAllMessages());
        }
    }

    public void userHasLogged() {
        LoggedUser loggedUser = LoggedUser.getINSTANCE();
        Hotel hotel  = HotelUtil.getByID(HotelUtil.getHotelList(),loggedUser.getUser().getId_hotel());
        assert hotel != null : "Hotel is null";
        hotelName.setText(hotel.getName());
        hotelAddress.setText(hotel.getAddress());

        /* SETTING FORMS INPUTS */
        packageChoose = PackageUtil.setCombobox(packageChoose, PackageUtil.excludeByHotelId(PackageUtil.getPackageList(), loggedUser.getUser().getId_hotel()));
    }

    /**
     * Czyści pola input sceny
     */
    public void clearScene() {
        numberOfPersons.setText("");

        // clear another scenes
        SceneController sceneController = SceneController.getInstance();
        ReservationBController reservationBController = sceneController.getLoader("worker/reservationB").getController();
        reservationBController.clearScene();
    }
}
