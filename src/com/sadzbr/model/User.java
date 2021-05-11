package com.sadzbr.model;

import com.sadzbr.controller.ServerConnection;

import java.util.List;

public class User extends Table {
    private int id_hotel;
    private String login;
    private String password;
    private String user_type;

    {
        tableName = "user";
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }


    @Override
    public int insert() {
        return -1;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    public void set(User user) {
        id = user.getId();
        id_hotel = user.getId_hotel();
        login = user.getLogin();
        password = user.getPassword();
        user_type = user.getUser_type();
    }

    @Override
    public boolean select() {
        ServerConnection serverConnection = new ServerConnection();
        Message message = new Message(this, "select");
        List<Table> response = serverConnection.sendMessage(message);
        if(response == null || response.isEmpty()) {
            return false;
        }
        User user = (User) response.get(0);
        set(user);
        return true;
    }

    @Override
    public List<Table> selectAll() {
        return null;
    }

    public boolean login() {
        ServerConnection serverConnection = new ServerConnection();
        Message message = new Message(this, "login");
        List<Table> response = serverConnection.sendMessage(message);
        if(response == null || response.isEmpty()) {
            return false;
        }
        User user = (User) response.get(0);
        set(user);
        return true;
    }
}
