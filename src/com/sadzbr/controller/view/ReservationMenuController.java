package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.service.LoggedUser;
import javafx.event.ActionEvent;

/**
 * Kontroler menu rezerwacji
 */
public class ReservationMenuController {

    /**
     * Handler elementu menu pokazania rezerwacji
     * @param actionEvent event
     */
    public void handleShowReservation(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationShow");
    }

    /**
     * Handler elementu menu zrobienia rezerwacji
     * @param actionEvent Event
     */
    public void handleMakeReservation(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("worker/reservationA");
    }

    /**
     * Handler elementu menu wylogowania się
     * @param actionEvent Event
     */
    public void handleLogout(ActionEvent actionEvent) {
        LoggedUser loggedUser = LoggedUser.getINSTANCE();
        loggedUser.setUser(null);
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("loginPanel");
    }
}
