package com.sadzbr.service;

import com.sadzbr.model.User;

/**
 * Klasa przechowująca dane zalogowanego użytkownika będąca singletonem.
 */
public class LoggedUser {
    /**
     * Użytkownik
     */
    private User user;
    /**
     * Instancja klasy
     */
    private final static LoggedUser INSTANCE = new LoggedUser();

    private LoggedUser() {}

    /**
     * Pobiera instancje
     * @return instancja
     */
    public static LoggedUser getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Pobiera aktualnie zalogowanego użytkownika
     * @return Użytkownika
     */
    public User getUser() {
        return user;
    }

    /**
     * Ustawia użytkownika
     * @param user Użytkownik
     */
    public void setUser(User user) {
        this.user = user;
    }
}
