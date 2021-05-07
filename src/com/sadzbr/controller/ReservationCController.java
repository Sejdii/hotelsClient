package com.sadzbr.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationCController implements Initializable {

    @FXML private TextArea summary;
    @FXML private ChoiceBox paymentMethod;


    public void handleChangeButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationB");
    }

    public void makeSummary() {
        String result = "";
        DataFlowController dataFlowController = DataFlowController.getInstance();

        result = result + "Liczba osób: " + dataFlowController.getValue("numberOfPersons") + "\n";
        result = result + "Pakiet: " + dataFlowController.getValue("package") + "\n";
        result = result + "Data przyjazdu: " + dataFlowController.getValue("dateArrival") + "\n";
        result = result + "Data odjazdu: " + dataFlowController.getValue("dateDeparture") + "\n";
        result = result + "Imię: " + dataFlowController.getValue("name") + "\n";
        result = result + "Nazwisko: " + dataFlowController.getValue("surname") + "\n";
        result = result + "Miasto: " + dataFlowController.getValue("city") + "\n";
        result = result + "Kod pocztowy: " + dataFlowController.getValue("postCode") + "\n";
        result = result + "Ulica: " + dataFlowController.getValue("street") + "\n";
        result = result + "Nr. domu: " + dataFlowController.getValue("homeNr") + "\n";
        result = result + "Nr. mieszkania: " + dataFlowController.getValue("flatNr") + "\n";

        summary.setText(result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        summary.setEditable(false);
    }
}
