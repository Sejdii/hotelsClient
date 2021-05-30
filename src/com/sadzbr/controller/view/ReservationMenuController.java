package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.service.LoggedUser;
import javafx.event.ActionEvent;

public class ReservationMenuController {

    public void handleShowReservation(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationShow");
    }

    public void handleMakeReservation(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationA");
    }

    public void handleLogout(ActionEvent actionEvent) {
        LoggedUser loggedUser = LoggedUser.getINSTANCE();
        loggedUser.setUser(null);
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("loginPanel");
    }
}
