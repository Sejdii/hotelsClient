package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Message;
import com.sadzbr.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.util.List;

/**
 * Metody dla tabeli hotel
 */
public class HotelUtil {
    /**
     * Pobiera listę hoteli
     * @return List hoteli
     */
    static public List<Table> getHotelList() {
        Message message = new Message("getHotelList", null);
        ServerConnection serverConnection =  new ServerConnection();
        return serverConnection.sendMessage(message);
    }

    /**
     * Zwraca hotel z listy o podanym id
     * @param tableList Lista
     * @param id ID
     * @return Hotel
     */
    static public Hotel getByID(List<Table> tableList, int id) {
        if(tableList == null || tableList.isEmpty()) return null;

        for(Table t : tableList) {
            Hotel hotel = (Hotel) t;
            if(hotel.getId() == id) {
                return hotel;
            }
        }
        return null;
    }

    /**
     * Konwertuje listę do ObservableList
     * @param tableList Lista
     * @return ObservableList
     */
    static public ObservableList<Hotel> convertToObservableList(List<Table> tableList) {
        ObservableList<Hotel> hotels = FXCollections.observableArrayList();
        for(Table t : tableList) {
            hotels.add((Hotel) t);
        }
        return hotels;
    }

    /**
     * Ustawia combobox
     * @param comboBox combobox
     * @param tableList lista
     * @return combobox
     */
    static public ComboBox setCombobox(ComboBox comboBox, List<Table> tableList) {
        ObservableList<Hotel> hotels = convertToObservableList(tableList);
        comboBox.setItems(hotels);
        comboBox.setValue((Hotel) tableList.get(0));
        comboBox.setConverter(new StringConverter<Hotel>() {
            @Override
            public String toString(Hotel object) {
                return object.getName();
            }

            @Override
            public Hotel fromString(String string) {
                return null;
            }
        });
        return comboBox;
    }

}
