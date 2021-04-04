package com.sadzbr.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class LoginPanelController {
    @FXML private Text errorContainer;

    @FXML protected void handleSubmitButtonAction(ActionEvent actionEvent) {
        errorContainer.setText("Something went wrong :(");
    }
}
