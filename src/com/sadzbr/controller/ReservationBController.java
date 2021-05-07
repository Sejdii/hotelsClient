package com.sadzbr.controller;

import com.sadzbr.utils.Validator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationBController implements Initializable {
    @FXML private CheckBox newsletter;
    @FXML private ChoiceBox roomChoose;
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
            DataFlowController dataFlowController = DataFlowController.getInstance();
            dataFlowController.addValue("email", email.getText());
            dataFlowController.addValue("room", roomChoose.getValue().toString());
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
            sceneController.activate("worker/reservationC");
            errorHandler.setText("");
        } else {
            errorHandler.setText(errorController.getAllMessages());
        }
    }
}
