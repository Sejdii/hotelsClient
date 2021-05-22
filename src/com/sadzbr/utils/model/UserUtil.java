package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Message;
import com.sadzbr.model.Table;
import com.sadzbr.model.User;

import java.util.List;

public class UserUtil {
    static public List<Table> getUserList() {
        Message message = new Message("getUserList", null);
        ServerConnection serverConnection = new ServerConnection();
        return serverConnection.sendMessage(message);
    }

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

    static public User insertUserList(User u) {
        Message message = new Message("insertUserList", u);
        ServerConnection serverConnection = new ServerConnection();
        List<Table> tableList = serverConnection.sendMessage(message);
        if(tableList == null || tableList.isEmpty()) return null;

        return (User)tableList.get(0);
    }

    static public void deleteUserList(User u) {
        Message message = new Message("deleteUserList", u);
        ServerConnection serverConnection = new ServerConnection();
        serverConnection.sendMessage(message);
    }

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

    static public void updateUserList(User u) {
        Message message = new Message("updateUserList", u);
        ServerConnection serverConnection = new ServerConnection();
        serverConnection.sendMessage(message);
    }

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
