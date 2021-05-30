package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.model.User;
import com.sadzbr.service.LoggedUser;
import com.sadzbr.utils.model.UserUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Kontroler panelu logowania
 */
public class LoginPanelController {
    /**
     * Pole hasło
     */
    @FXML private PasswordField passwordField;
    /**
     * Pole login
     */
    @FXML private TextField loginField;
    /**
     * Kontener wyświetlający błędy
     */
    @FXML private Text errorContainer;

    /**
     * Handler dla przycisku zaloguj się
     * @param actionEvent Event
     */
    @FXML protected void handleSubmitButtonAction(ActionEvent actionEvent) {
        User user = new User();
        user.setLogin(loginField.getText());
        user.setPassword(passwordField.getText());
        if((user = UserUtil.loginUser(user)) != null) {
            SceneController sceneController = SceneController.getInstance();
            LoggedUser loggedUser = LoggedUser.getINSTANCE();
            loggedUser.setUser(user);
            loginField.setText("");
            passwordField.setText("");
            errorContainer.setText("");
            if(user.getUser_type().equals("admin")) {
                sceneController.activate("admin/adminChooseAction");
            } else if(user.getUser_type().equals("pracownik")) {
                FXMLLoader fxmlLoader = sceneController.getLoader("worker/reservationA");
                ReservationAController reservationAController = fxmlLoader.getController();
                reservationAController.userHasLogged();
                fxmlLoader = sceneController.getLoader("worker/reservationShow");
                ReservationShowController reservationShowController = fxmlLoader.getController();
                reservationShowController.userHasLogged();
                reservationAController.clearScene();

                sceneController.activate("worker/reservationA");
            }
        } else {
            errorContainer.setText("Niepoprawna nazwa użytkownika lub hasło");
        }
    }
}
