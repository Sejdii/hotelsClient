package com.sadzbr.controller.view;

import com.sadzbr.controller.ErrorController;
import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Table;
import com.sadzbr.model.User;
import com.sadzbr.utils.Validator;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.UserUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WorkerEditFormController implements Initializable {
    @FXML private Text errorContainer;
    @FXML private PasswordField password;
    @FXML private TextField login;
    @FXML private ComboBox<Hotel> hotel_id;
    @FXML private ChoiceBox user_type;

    private int worker_id = -1;

    public void handleCancelButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/workerEdit");
        this.worker_id = -1;
        errorContainer.setText("");
        password.setText("");
        login.setText("");
    }

    public void handleSaveButton(ActionEvent actionEvent) {
        User user = new User();
        user.setPassword(password.getText());
        user.setLogin(login.getText());
        user.setId_hotel(hotel_id.getValue().getId());
        user.setUser_type(user_type.getValue().toString());
        boolean valid = true;

        ErrorController errorController = ErrorController.getInstance();
        errorContainer.setText("Trwa walidacja dla Login: " + user.getLogin());
        if(!Validator.login(user.getLogin())) {
            errorContainer.setText(errorController.getAllMessages());
            valid = false;
        }
        if(worker_id == -1 && !UserUtil.isLoginUnique(user)) {
            errorContainer.setText("Podany login jest już w użytku");
        }

        if(valid) {
            if(worker_id == -1) { // if -1 then we don't edit, we insert new user
                UserUtil.insertUserList(user);
            } else {
                user.setId(worker_id);
                UserUtil.updateUserList(user);
            }
            handleCancelButton(actionEvent);
        }
    }

    public void setWorkerID(int id) {
        List<Table> tableList = UserUtil.getUserList();
        User user = UserUtil.getByID(tableList, id);
        if(user != null) {
            this.worker_id = id;
            login.setText(user.getLogin());
            user_type.setValue(user.getUser_type());
            Hotel hotel = HotelUtil.getByID(HotelUtil.getHotelList(), user.getId_hotel());
            assert hotel != null;
            hotel_id.setValue(hotel);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Table> tableList = HotelUtil.getHotelList();
        hotel_id = HotelUtil.setCombobox(hotel_id, tableList);
    }
}
