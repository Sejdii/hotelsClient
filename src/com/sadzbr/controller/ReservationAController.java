package com.sadzbr.controller;

import com.sadzbr.utils.Validator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReservationAController implements Initializable {
    @FXML private Text errorHandler;
    @FXML private DatePicker dateDeparture;
    @FXML private DatePicker dateArrival;
    @FXML private TextField numberOfPersons;
    @FXML private ChoiceBox packageChoose;

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
        //TODO sprawdzanie czy pokój jest dostępny
        //Validation
        ErrorController errorController = ErrorController.getInstance();
        Validator.reservationDates(dateArrival.getValue(), dateDeparture.getValue());
        if(numberOfPersons.getText().equals("")) { // if TextField numberOfPersons is empty set to 0
            numberOfPersons.setText("0");
        }
        Validator.numberOfPersons(Integer.parseInt(numberOfPersons.getText()));

        if(errorController.isEmpty()) {
            // everything is okey we can go to next scene
            // sending data to another scenes
            DataFlowController dataFlowController = DataFlowController.getInstance();
            dataFlowController.addValue("numberOfPersons", numberOfPersons.getText());

            SceneController sceneController = SceneController.getInstance();
            sceneController.activate("worker/reservationB");
            errorHandler.setText("");
        } else {
            errorHandler.setText(errorController.getAllMessages());
        }
    }
}
