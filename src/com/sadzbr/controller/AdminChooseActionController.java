package com.sadzbr.controller;

import javafx.event.ActionEvent;

public class AdminChooseActionController {

    public void handleWorkersButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/workerEdit");
    }

    public void handleHotelsButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/hotelEdit");
    }
}
