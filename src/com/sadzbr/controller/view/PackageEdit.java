package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import javafx.event.ActionEvent;

public class PackageEdit {
    public void handleAddNewButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/packageEditForm");
    }
}
