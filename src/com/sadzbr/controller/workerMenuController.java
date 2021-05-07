package com.sadzbr.controller;

import javafx.event.ActionEvent;

public class workerMenuController {

    public void handleEditHotel(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/hotelEdit");
    }

    public void handleEditPackage(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/packageEdit");
    }

    public void handleRoomEdit(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/roomEdit");
    }

    public void handleWorkerEdit(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/workerEdit");
    }

    public void handleLogout(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        //TODO dodać kod wylogowania użytkownika
        sceneController.activate("loginPanel");
    }
}
