package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Message;
import com.sadzbr.model.Table;
import com.sadzbr.model.User;

import java.util.List;

public class HotelUtil {
    static public List<Table> getHotelList() {
        Message message = new Message("getHotelList", null);
        ServerConnection serverConnection =  new ServerConnection();
        return serverConnection.sendMessage(message);
    }

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
}
