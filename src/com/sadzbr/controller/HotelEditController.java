package com.sadzbr.controller;

import javafx.event.ActionEvent;

public class HotelEditController {
    public void handlePackageButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/packageEdit");
    }

    public void handleRoomEdit(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/roomEdit");
    }
}
