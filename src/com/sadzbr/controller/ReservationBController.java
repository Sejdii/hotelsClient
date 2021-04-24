package com.sadzbr.controller;

import com.sadzbr.utils.Validator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationBController implements Initializable {
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

    public void handleReturnButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationA");
    }

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

        if(errorController.isEmpty()) {
            // everything is okey we can go to next scene
            // sending data to another scenes

            SceneController sceneController = SceneController.getInstance();
            sceneController.activate("worker/reservationC");
            errorHandler.setText("");
        } else {
            errorHandler.setText(errorController.getAllMessages());
        }
    }
}
