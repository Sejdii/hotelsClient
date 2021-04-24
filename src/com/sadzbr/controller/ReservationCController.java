package com.sadzbr.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationCController implements Initializable {

    @FXML private TextField summary;
    @FXML private ChoiceBox paymentMethod;


    public void handleChangeButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationB");
    }

    public void makeSummary() {
        String result = "";
        DataFlowController dataFlowController = DataFlowController.getInstance();

        result = result + "Liczba osób " + dataFlowController.getValue("numberOfPersons");

        summary.setText(result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        summary.setEditable(false);
    }
}
