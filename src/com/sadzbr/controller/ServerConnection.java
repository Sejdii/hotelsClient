package com.sadzbr.controller;

import com.sadzbr.model.Message;
import com.sadzbr.model.Table;
import com.sadzbr.utils.Messages;
import com.sadzbr.utils.Settings;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Klasa realizująca połączenie z serwerem. Właściwości połączenia są ustalone w klasie com.sadzbr.utils.Settings
 */
public class ServerConnection {
    /**
     * Wysłanie wiadomości do serwera
     * @param m Wiadomość
     * @return Odpowiedź serwera
     */
    public List<Table> sendMessage(Message m) {
        List<Table> response = null;
        try (Socket socket = new Socket(Settings.SERVER_HOST, Settings.SERVER_PORT)) {

            // send message to server
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(m);

            // get response from server
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            response = (List<Table>) objectInputStream.readObject();

            objectInputStream.close();
            objectOutputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            Messages.logMessage("Send message to server error: " + e.getMessage(), true);
        }
        return response;
    }
}
