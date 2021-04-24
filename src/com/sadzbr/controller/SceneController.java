package com.sadzbr.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class SceneController {
    private final HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;
    private final static SceneController INSTANCE = new SceneController();

    private SceneController() {}

    public static SceneController getInstance() {
        return INSTANCE;
    }

    public void setMain(Scene main) {
        this.main = main;
    }

    public void addScene(String name, Pane pane) {
        screenMap.put(name, pane);
    }

    public void removeScene(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        main.setRoot(screenMap.get(name));
    }

    public Pane getPane(String name) {
        return screenMap.get(name);
    }
}
