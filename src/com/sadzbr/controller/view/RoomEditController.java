package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Message;
import com.sadzbr.model.Rooms;
import com.sadzbr.model.Table;
import com.sadzbr.utils.Messages;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.RoomsUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoomEditController implements Initializable {
    @FXML private Text errorContainer;
    @FXML private TextField price;
    @FXML private ComboBox<Rooms> room_id;
    @FXML private ComboBox<Hotel> id_hotel;

    public void handleConfirmButton(ActionEvent actionEvent) {
        Rooms rooms = (Rooms)room_id.getValue();

        if(price.getText().isEmpty() || room_id.getValue() == null) {
            errorContainer.setText("Wymagane pole jest puste");
            return;
        }
        rooms.setPrice(Double.parseDouble(price.getText()));

        RoomsUtil.updateRoomsList(rooms);
        handleHotelIdChange(actionEvent);

        errorContainer.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Table> tableList = HotelUtil.getHotelList();
        id_hotel = HotelUtil.setCombobox(id_hotel, tableList);
        int idHotelVal = ((Hotel)id_hotel.getValue()).getId();

        List<Table> roomsList = RoomsUtil.getRoomsList();
        roomsList = RoomsUtil.excludeByIdHotel(roomsList, idHotelVal);
        room_id = RoomsUtil.setCombobox(room_id, roomsList);

        price.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    price.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void handleCancelButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/hotelEdit");
    }

    public void handleHotelIdChange(ActionEvent actionEvent) {
        int idHotelVal = ((Hotel)id_hotel.getValue()).getId();

        List<Table> roomsList = RoomsUtil.getRoomsList();
        roomsList = RoomsUtil.excludeByIdHotel(roomsList, idHotelVal);
        room_id = RoomsUtil.setCombobox(room_id, roomsList);

        price.setText("");
    }

    public void handleRoomsIdChange(ActionEvent actionEvent) {
        if(room_id.getValue() == null) return;
        double priceVal = ((Rooms)room_id.getValue()).getPrice();
        price.setText(String.valueOf((int)priceVal));
    }
}
