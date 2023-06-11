package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.entities.room.RoomStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.createRoomUseCase;

public class RoomCreateUIController {
    @FXML
    private TextField txtNumberRoom;
    @FXML
    private ComboBox<RoomStatus> cbStatusRoom;
    @FXML
    private Label lbSuccess;
    private Room room;

    @FXML
    public void initialize() {
        cbStatusRoom.getItems().addAll(RoomStatus.values());
    }

    public void createRoom(ActionEvent actionEvent) throws IOException {
        getEntityFromView();
        createRoomUseCase.insert(room);
        displaysSuccessMessage();
    }

    private void displaysSuccessMessage() {
        lbSuccess.setVisible(true);
        lbSuccess.setManaged(true);
    }

    private void getEntityFromView() {
        RoomStatus selectedStatus = cbStatusRoom.getValue();

        room = new Room(Integer.valueOf(txtNumberRoom.getText()), selectedStatus);
    }

    public void returnRoomMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("RoomUI");
    }
}
