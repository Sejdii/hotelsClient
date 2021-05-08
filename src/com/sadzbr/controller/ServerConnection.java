package com.sadzbr.controller;

import com.sadzbr.model.Message;
import com.sadzbr.model.User;
import com.sadzbr.utils.Settings;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerConnection {
    public boolean sendMessage(Message m) {
        try (Socket socket = new Socket(Settings.SERVER_HOST, Settings.SERVER_PORT)) {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(m);
            socket.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
