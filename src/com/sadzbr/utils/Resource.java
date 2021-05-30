package com.sadzbr.utils;

/**
 * Metody dla zasobów
 */
public class Resource {
    /**
     * Pobiera ścieżkę do widoku
     * @param name Nazwa widoku
     * @return ścieżka
     */
    static public String view(String name) {
        return  "/resources/view/" + name + ".fxml";
    }
}
