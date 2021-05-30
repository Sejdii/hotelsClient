package com.sadzbr.utils;

import javafx.scene.control.Alert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Messages {
    /**
     * Loguje wiadomość do pliku .log. Jeżeli wystąpi błąd wyświetli go również na ekran w formie popup.
     * @param message Wiadomość
     * @param isError Określa czy wystąpił błąd
     */
    static public void logMessage(String message, boolean isError) {
        Logger logger = Logger.getLogger("com.sadzbr");
        if(isError) {
            logger.warning(message);

            // show error popup
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd programu");
            alert.setHeaderText("Podczas wykonywania program wydarzył się nieoczekiwany błąd");
            alert.setContentText(message);
            alert.showAndWait();
        } else {
            logger.info(message);
        }
    }

    /**
     * Ustawia logger serwera. Obecna ustawienia zapisują logi w folderze domowym użytkownika. Konfiguracja pobierana
     * przez metodę znajduje się w pliku app.properties.
     * @return Zwraca true przy powodzeniu lub false w przeciwnym razie.
     */
    static public boolean setLogger() {
        Logger logger = Logger.getLogger("com.sadzbr");
        try {
            FileInputStream properties = new FileInputStream("app.properties");
            LogManager.getLogManager().readConfiguration(properties);


            properties.close();
        } catch (IOException e) {
            e.printStackTrace();
            logMessage("Set logger error " + e.getMessage(), true);
            return false;
        }
        return true;
    }
}
