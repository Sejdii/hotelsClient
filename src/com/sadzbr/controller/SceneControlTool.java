package com.sadzbr.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;

/**
 * Kontroler okienka wyboru sceny. Wyłączony w ostatecznej wersji programu.
 */
public class SceneControlTool {
    public ChoiceBox choiceBoxValue;

    public void choiceBoxListener(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        String value = choiceBoxValue.getValue().toString();
        sceneController.activate(value);
    }
}
