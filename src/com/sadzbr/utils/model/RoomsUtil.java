package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Message;
import com.sadzbr.model.Rooms;
import com.sadzbr.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

public class RoomsUtil {
    static public List<Table> getRoomsList() {
        Message message = new Message("getRoomsList", null);
        ServerConnection serverConnection =  new ServerConnection();
        return serverConnection.sendMessage(message);
    }

    static public void updateRoomsList(Rooms r) {
        Message message = new Message("updateRoomsList", r);
        ServerConnection serverConnection =  new ServerConnection();
        serverConnection.sendMessage(message);
    }

    static public ObservableList<Rooms> convertToObservableList(List<Table> tableList) {
        ObservableList<Rooms> rooms = FXCollections.observableArrayList();
        for(Table t : tableList) {
            rooms.add((Rooms) t);
        }
        return rooms;
    }

    static public ComboBox setCombobox(ComboBox comboBox, List<Table> tableList) {
        ObservableList<Rooms> rooms = convertToObservableList(tableList);
        comboBox.setItems(rooms);
        //comboBox.setValue((Rooms) tableList.get(0));
        comboBox.setConverter(new StringConverter<Rooms>() {
            @Override
            public String toString(Rooms object) {
                return String.valueOf(object.getRoom_nr());
            }

            @Override
            public Rooms fromString(String string) {
                return null;
            }
        });
        return comboBox;
    }

    static public List<Table> excludeByIdHotel(List<Table> tableList, int idHotel) {
        List<Table> retList = new ArrayList<>();
        for(Table t : tableList) {
            Rooms rooms = (Rooms) t;
            if(rooms.getId_hotel() == idHotel) {
                retList.add(rooms);
            }
        }
        return retList;
    }
}
