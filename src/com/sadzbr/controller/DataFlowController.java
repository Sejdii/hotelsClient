package com.sadzbr.controller;

import javax.xml.crypto.Data;
import java.util.HashMap;

/**
 * Kontroler przepływu danych pomiędzy wszystkimi scenami. Zaimplementowany jako Singleton.
 */
public class DataFlowController {
    /**
     * HashMap przechowuje wartości które chcemy przesyłać
     */
    private final HashMap<String, String> values = new HashMap<>();
    /**
     * Instancja obiektu
     */
    private final static DataFlowController INSTANCE = new DataFlowController();

    private DataFlowController() {}

    /**
     * Pozwala pobrać instancje
     * @return instancja
     */
    public static DataFlowController getInstance() {
        return INSTANCE;
    }

    /**
     * Dodaje wartość o danym kluczu do HashMapy
     * @param key klucz
     * @param value wartośc
     */
    public void addValue(String key, String value) {
        values.put(key, value);
    }

    /**
     * Pobiera wartość o danym kluczu z HashMapy
     * @param key klucz
     * @return wartość skojarzona z kluczem
     */
    public String getValue(String key) {
        return values.get(key);
    }

    /**
     * Usuwa wartość o danym kluczu z HashMapy
     * @param key klucz
     */
    public void deleteValue(String key) {
        values.remove(key);
    }
}
