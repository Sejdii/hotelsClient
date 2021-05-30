package com.sadzbr.controller;

import java.util.Stack;

/**
 * Kontroler występowania błędów będący singletonem.
 */
public class ErrorController {
    /**
     * Stos błędów
     */
    private final Stack<String> errorStack = new Stack<>();
    /**
     * Instancja klasy
     */
    private final static ErrorController INSTANCE = new ErrorController();


    private  ErrorController() {}

    /**
     * Pobiera instancję
     * @return Instancja
     */
    public static ErrorController getInstance() {
        return INSTANCE;
    }

    /**
     * Dodaje wiadomość o błędzie
     * @param message Wiadomość
     */
    public void addMessage(String message) {
        errorStack.push(message);
    }

    /**
     * Pobiera ostatnią wiadomość
     * @return Wiadomość
     */
    public String getLastMessage() {
        return errorStack.pop();
    }

    /**
     * Sprawdza czy stos jest pusty
     * @return Zwraca true jeżeli pusty, false w przeciwnym wypadku
     */
    public boolean isEmpty() {
        return errorStack.isEmpty();
    }

    /**
     * Pobiera wszystkie wiadomości ze stosu błędów
     * @return Wiadomości
     */
    public String getAllMessages() {
        String message = "";
        while(!errorStack.isEmpty()) {
            message = message + errorStack.pop() + "\n";
        }
        if(!message.equals("")) {
            message = message.substring(0, message.length()-1);
        }
        return message;
    }
}
