package com.sadzbr.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;

public class SceneController {
    private final HashMap<String, FXMLLoader> screenMap = new HashMap<>();
    private final HashMap<String, Parent> parentMap = new HashMap<>();
    private Scene main;
    private final static SceneController INSTANCE = new SceneController();

    private SceneController() {}

    public static SceneController getInstance() {
        return INSTANCE;
    }

    public void setMain(Scene main) {
        this.main = main;
    }

    public void addScene(String name, FXMLLoader loader) {
        try {
            screenMap.put(name, loader);
            parentMap.put(name, loader.load());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeScene(String name) {
        screenMap.remove(name);
        parentMap.remove(name);
    }

    public void activate(String name) {
        try {
            if(parentMap.containsKey(name)) {
                main.setRoot(parentMap.get(name));
            } else {
                Parent root = screenMap.get(name).load();
                main.setRoot(root);
                parentMap.put(name, root);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public FXMLLoader getLoader(String name) {
        return screenMap.get(name);
    }

}
