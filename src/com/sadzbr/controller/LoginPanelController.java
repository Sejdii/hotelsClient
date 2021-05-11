package com.sadzbr.controller;

import com.sadzbr.model.Message;
import com.sadzbr.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginPanelController {
    @FXML private PasswordField passwordField;
    @FXML private TextField loginField;
    @FXML private Text errorContainer;

    @FXML protected void handleSubmitButtonAction(ActionEvent actionEvent) {
        ServerConnection serverConnection = new ServerConnection();
        User user = new User();
        user.setLogin(loginField.getText());
        user.setPassword(passwordField.getText());
        if(user.login()) {
            //TODO user successfully logged
            errorContainer.setText("Jeej udalo sie " + user.getLogin() + " " + user.getPassword());
        } else {
            errorContainer.setText("Niepoprawna nazwa użytkownika lub hasło");
        }
    }
}
