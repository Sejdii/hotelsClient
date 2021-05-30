package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import javafx.event.ActionEvent;

/**
 * Kontroler dla sceny wyboru opcji
 */
public class AdminChooseActionController {

    /**
     * handler dla przycisku pracownik
     * @param actionEvent Event
     */
    public void handleWorkersButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/workerEdit");
    }

    /**
     * handler dla przycisku hotele
     * @param actionEvent Event
     */
    public void handleHotelsButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/hotelEdit");
    }
}
