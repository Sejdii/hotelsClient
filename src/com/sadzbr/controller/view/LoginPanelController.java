package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Message;
import com.sadzbr.model.User;
import com.sadzbr.service.LoggedUser;
import com.sadzbr.utils.model.UserUtil;
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
        User user = new User();
        user.setLogin(loginField.getText());
        user.setPassword(passwordField.getText());
        if((user = UserUtil.loginUser(user)) != null) {
            SceneController sceneController = SceneController.getInstance();
            LoggedUser loggedUser = LoggedUser.getINSTANCE();
            loggedUser.setUser(user);
            if(user.getUser_type().equals("admin")) {
                sceneController.activate("admin/adminChooseAction");
            } else if(user.getUser_type().equals("pracownik")) {
                sceneController.activate("worker/reservationA");
            }
        } else {
            errorContainer.setText("Niepoprawna nazwa użytkownika lub hasło");
        }
    }
}
