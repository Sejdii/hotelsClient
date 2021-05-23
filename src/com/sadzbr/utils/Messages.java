package com.sadzbr.utils;

import javafx.scene.control.Alert;

import java.util.logging.Logger;

public class Messages {
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
        }
        logger.info(message);
    }
}
