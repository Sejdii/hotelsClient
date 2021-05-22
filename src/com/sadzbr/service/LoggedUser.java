package com.sadzbr.service;

import com.sadzbr.model.User;

public class LoggedUser {
    private User user;
    private final static LoggedUser INSTANCE = new LoggedUser();

    private LoggedUser() {}

    public static LoggedUser getINSTANCE() {
        return INSTANCE;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
