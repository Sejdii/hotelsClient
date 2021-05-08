package com.sadzbr.controller;

import com.sadzbr.model.Message;
import com.sadzbr.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginPanelController {
    @FXML private TextField loginField;
    @FXML private Text errorContainer;

    @FXML protected void handleSubmitButtonAction(ActionEvent actionEvent) {
        ServerConnection serverConnection = new ServerConnection();
        User user = new User();
        user.setLogin("aba");
        user.setPassword("baba");
        Message m = new Message(user, "login");
        if(!serverConnection.sendMessage(m)) {
            errorContainer.setText("Server connection error :(");
        }
    }
}
