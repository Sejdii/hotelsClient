package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Message;
import com.sadzbr.model.Table;
import com.sadzbr.model.User;

import java.util.List;

/**
 * Metody dla tabeli user
 */
public class UserUtil {
    /**
     * Pobiera listę użytkowników
     * @return lista
     */
    static public List<Table> getUserList() {
        Message message = new Message("getUserList", null);
        ServerConnection serverConnection = new ServerConnection();
        return serverConnection.sendMessage(message);
    }

    /**
     * Loguje użytkownika
     * @param u Użytkownik
     * @return Użytkownik
     */
    static public User loginUser(User u) {
        List<Table> tableList = UserUtil.getUserList();
        if(tableList == null || tableList.isEmpty()) {
            return null;
        }

        for(Table table : tableList) {
            User user = (User) table;
            if(user.getLogin().equals(u.getLogin())) {
                if(user.getPassword().equals(u.getPassword())) {
                    return user;
                }
            }
        }
        return null;
    }

    /**
     * Realizuje polecenie insert na tabeli
     * @param u Użytkownik
     * @return Zwraca użytkownika
     */
    static public User insertUserList(User u) {
        Message message = new Message("insertUserList", u);
        ServerConnection serverConnection = new ServerConnection();
        List<Table> tableList = serverConnection.sendMessage(message);
        if(tableList == null || tableList.isEmpty()) return null;

        return (User)tableList.get(0);
    }

    /**
     * Realizuje polecenie delete na tabeli
     * @param u Użytkownik
     */
    static public void deleteUserList(User u) {
        Message message = new Message("deleteUserList", u);
        ServerConnection serverConnection = new ServerConnection();
        serverConnection.sendMessage(message);
    }

    /**
     * Pobiera element z listy na podstawie jego ID
     * @param tableList lista
     * @param id ID
     * @return użytkownik
     */
    static public User getByID(List<Table> tableList, int id) {
        if(tableList == null || tableList.isEmpty()) return null;

        for(Table t : tableList) {
            User user = (User) t;
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * Realizuje polecenie update na tabeli
     * @param u Użytkownik
     */
    static public void updateUserList(User u) {
        Message message = new Message("updateUserList", u);
        ServerConnection serverConnection = new ServerConnection();
        serverConnection.sendMessage(message);
    }

    /**
     * Sprawdza czy login jest unikalny
     * @param u Użytkownik
     * @return Zwraca true jeżeli login jest unikalny, false w przeciwnym wypadku.
     */
    static public boolean isLoginUnique(User u) {
        List<Table> tableList = getUserList();
        for(Table t : tableList) {
            User user = (User) t;
            if(u.getLogin().equals(user.getLogin())) {
                return false;
            }
        }
        return true;
    }
}
