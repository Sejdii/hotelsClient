package com.sadzbr.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginPanelController {
    @FXML private TextField loginField;
    @FXML private Text errorContainer;

    @FXML protected void handleSubmitButtonAction(ActionEvent actionEvent) {
        errorContainer.setText("Something went wrong :( Login: " + loginField.getText());
    }
}
