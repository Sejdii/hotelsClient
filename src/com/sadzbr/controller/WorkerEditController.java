package com.sadzbr.controller;

import javafx.event.ActionEvent;

public class WorkerEditController {
    public void handleAddNewButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/workerEditForm");
    }
}
