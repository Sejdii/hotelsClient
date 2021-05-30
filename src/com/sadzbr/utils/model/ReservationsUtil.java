package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Message;
import com.sadzbr.model.Reservations;
import com.sadzbr.model.Rooms;
import com.sadzbr.model.Table;
import com.sadzbr.service.LoggedUser;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Metody dla tabeli reservations
 */
public class ReservationsUtil {
    /**
     * Sprawdza dostępność pokoi dla podanych danych w danym hotelu
     * @param personsNumber Liczba osób
     * @param startDate Data początku
     * @param endDate Data końca
     * @return Zwraca true jeżeli pokoje są dostępne, false w przeciwnym wypadku.
     */
    static public boolean checkAvailability(int personsNumber, Date startDate, Date endDate) {
        List<Table> response = getAvailabilityRoomsList(personsNumber, startDate, endDate);
        return response != null && !response.isEmpty();
    }

    /**
     * Konwertuje LocalDate na Date
     * @param date Data
     * @return data po konwersji
     */
    static public Date convertDateFromLocal(LocalDate date) {
        ZoneId zoneId = ZoneId.systemDefault();
        Date date1 = Date.from(date.atStartOfDay(zoneId).toInstant());
        return date1;
    }

    /**
     * Pobiera listę dostępnych pokoi dla podanych danych i danego hotelu
     * @param personsNumber Liczba osób
     * @param startDate Data początku
     * @param endDate Data końca
     * @return Lista dostępnych pokoi
     */
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

    /**
     * Wyodrębnia pokoje z listy poprzez id hotelu
     * @param tableList lista
     * @param id id hotelu
     * @return nowa lista
     */
    static public List<Table> excludeByHotelID(List<Table> tableList, int id) {
        List<Table> retList = new ArrayList<>();
        for(Table t : tableList) {
            Reservations x = (Reservations) t;
            TableUtil<Rooms> roomsTableUtil = new TableUtil<>(Rooms::new);
            Rooms r = roomsTableUtil.getByID(roomsTableUtil.getList(), x.getId_room());
            if(r.getId_hotel() == id) {
                retList.add(x);
            }
        }
        return retList;
    }

    /**
     * Zamienia pole id_room na wartość pobraną z pola room_nr
     * @param tableList lista
     * @return lista
     */
    static public List<Table> replaceIdRoomByNr(List<Table> tableList) {
        for(Table t : tableList) {
            Reservations x = (Reservations) t;
            TableUtil<Rooms> roomsTableUtil = new TableUtil<>(Rooms::new);
            Rooms r = roomsTableUtil.getByID(roomsTableUtil.getList(), x.getId_room());
            x.setId_room(r.getRoom_nr());
        }
        return tableList;
    }
}
