package com.sadzbr.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

/**
 * Kontroler sceny będący singletonem
 */
public class SceneController {
    /**
     * Mapa ekranu
     */
    private final HashMap<String, FXMLLoader> screenMap = new HashMap<>();
    /**
     * Mapa rodziców
     */
    private final HashMap<String, Parent> parentMap = new HashMap<>();
    /**
     * Główna scena
     */
    private Scene main;
    /**
     * Instacja klasy
     */
    private final static SceneController INSTANCE = new SceneController();

    private SceneController() {}

    /**
     * Pobiera instancje
     * @return instancja
     */
    public static SceneController getInstance() {
        return INSTANCE;
    }

    /**
     * Ustawia główną scenę
     * @param main Scena
     */
    public void setMain(Scene main) {
        this.main = main;
    }

    /**
     * Dodaje scenę
     * @param name Nazwa
     * @param loader Loader sceny
     */
    public void addScene(String name, FXMLLoader loader) {
        try {
            screenMap.put(name, loader);
            parentMap.put(name, loader.load());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Usuwa scenę
     * @param name Nazwa
     */
    public void removeScene(String name) {
        screenMap.remove(name);
        parentMap.remove(name);
    }

    /**
     * Aktywuje scenę
     * @param name Nazwa
     */
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

    /**
     * Pobiera loader danej sceny
     * @param name Nazwa
     * @return Loader
     */
    public FXMLLoader getLoader(String name) {
        return screenMap.get(name);
    }

}
