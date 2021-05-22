package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomEditController implements Initializable {
    @FXML private TextField price;
    @FXML private ComboBox room_id;
    @FXML private ComboBox id_hotel;

    public void handleConfirmButton(ActionEvent actionEvent) {
        //TODO aktualizacja danych o pokoju w bazie
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO uzupełnienie combobox hotelami pobranymi z bazy
    }

    public void handleCancelButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/hotelEdit");
    }
}
