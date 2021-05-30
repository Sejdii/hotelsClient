package com.sadzbr.controller.view;

import com.sadzbr.model.Hotel;
import com.sadzbr.model.Reservations;
import com.sadzbr.model.User;
import com.sadzbr.service.LoggedUser;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.TableUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservationShowController implements Initializable {
    @FXML private TableView<Reservations> reservationTable;
    @FXML private Text hotelAddress;
    @FXML private Text hotelName;

    public void handleRefreshButton(ActionEvent actionEvent) {
        TableUtil<Reservations> reservationsTableUtil = new TableUtil<>(Reservations::new);
        reservationTable.setItems(reservationsTableUtil.convertToObservableList(reservationsTableUtil.getList()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TableColumn<Reservations, Integer> idRoomColumn = new TableColumn<>("Pokój");
        idRoomColumn.setCellValueFactory(new PropertyValueFactory<Reservations, Integer>("id_room"));
        idRoomColumn.setMinWidth(100);

        TableColumn<Reservations, String> startDateColumn = new TableColumn<>("Data początku");
        startDateColumn.setCellValueFactory(new PropertyValueFactory<Reservations, String>("date_start"));
        startDateColumn.setMinWidth(100);

        TableColumn<Reservations, String> endDateColumn = new TableColumn<>("Data końca");
        endDateColumn.setCellValueFactory(new PropertyValueFactory<Reservations, String>("date_end"));
        endDateColumn.setMinWidth(100);

        reservationTable.getColumns().addAll(idRoomColumn, startDateColumn, endDateColumn);
    }

    public void userHasLogged() {
        LoggedUser loggedUser = LoggedUser.getINSTANCE();
        Hotel hotel  = HotelUtil.getByID(HotelUtil.getHotelList(),loggedUser.getUser().getId_hotel());
        assert hotel != null : "Hotel is null";
        hotelName.setText(hotel.getName());
        hotelAddress.setText(hotel.getAddress());
    }
}
