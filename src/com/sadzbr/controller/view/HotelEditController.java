package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import javafx.event.ActionEvent;

/**
 * Kontroler dla edycji hoteli
 */
public class HotelEditController {
    /**
     * Handler dla przycisku pakiet
     * @param actionEvent Event
     */
    public void handlePackageButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/packageEdit");
    }

    /**
     * Handler dla przycisku pokój
     * @param actionEvent Event
     */
    public void handleRoomEdit(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/roomEdit");
    }
}
