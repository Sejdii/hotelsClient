package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.service.LoggedUser;
import javafx.event.ActionEvent;

/**
 * Kontroler menu pracownika
 */
public class workerMenuController {

    /**
     * Handler pola menu edycji hotelu
     * @param actionEvent event
     */
    public void handleEditHotel(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/hotelEdit");
    }

    /**
     * Handler pola menu edycji pakietu
     * @param actionEvent event
     */
    public void handleEditPackage(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/packageEdit");
    }

    /**
     * Handler pola menu edycji pokoju
     * @param actionEvent event
     */
    public void handleRoomEdit(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/roomEdit");
    }

    /**
     * Handler pola menu edycji pracownika
     * @param actionEvent event
     */
    public void handleWorkerEdit(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/workerEdit");
    }

    /**
     * Handler pola menu wylogowania się
     * @param actionEvent event
     */
    public void handleLogout(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        LoggedUser loggedUser = LoggedUser.getINSTANCE();
        loggedUser.setUser(null);
        sceneController.activate("loginPanel");
    }
}
