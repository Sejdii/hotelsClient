package com.sadzbr.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;

public class SceneControlTool {

    public ChoiceBox choiceBoxValue;

    public void choiceBoxListener(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        String value = choiceBoxValue.getValue().toString();
        sceneController.activate(value);
    }
}
