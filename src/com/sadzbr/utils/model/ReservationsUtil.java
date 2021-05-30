package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Message;
import com.sadzbr.model.Reservations;
import com.sadzbr.model.Table;
import com.sadzbr.service.LoggedUser;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class ReservationsUtil {
    static public boolean checkAvailability(int personsNumber, Date startDate, Date endDate) {
        List<Table> response = getAvailabilityRoomsList(personsNumber, startDate, endDate);
        return response != null && !response.isEmpty();
    }

    static public Date convertDateFromLocal(LocalDate date) {
        ZoneId zoneId = ZoneId.systemDefault();
        Date date1 = Date.from(date.atStartOfDay(zoneId).toInstant());
        return date1;
    }

    static public List<Table> getAvailabilityRoomsList(int personsNumber, Date startDate, Date endDate) {
        Reservations reservations = new Reservations();
        reservations.setDate_start(startDate);
        reservations.setDate_end(endDate);
        reservations.setId_room(LoggedUser.getINSTANCE().getUser().getId_hotel()); // for socket communication id_room handle id_hotel
        reservations.setId_package(personsNumber); // for socket communication id_package handle number_of_persons
        Message message = new Message("getAvailableRoomsList", reservations);
        ServerConnection serverConnection = new ServerConnection();
        return serverConnection.sendMessage(message);
    }
}
