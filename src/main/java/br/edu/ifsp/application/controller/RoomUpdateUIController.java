package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.entities.room.RoomStatus;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static br.edu.ifsp.application.main.Main.findRoomUseCase;
import static br.edu.ifsp.application.main.Main.updateRoomUseCase;

public class RoomUpdateUIController {
    @FXML
    private TextField txtNumberRoom;
    @FXML
    private ComboBox<RoomStatus> cbStatusRoom;
    private Room room;

    public void updateRoom(ActionEvent actionEvent) {
        room.setRoomStatus(cbStatusRoom.getValue());
        updateRoomUseCase.update(room);
        String messagen = "Quarto atualizado com sucesso!";
        showAlert("Success!", messagen, Alert.AlertType.INFORMATION);
        clearData();
    }

    public void clearRoomData(ActionEvent actionEvent) {
        clearData();
    }

    private void clearData() {
        txtNumberRoom.clear();
        cbStatusRoom.getSelectionModel().clearSelection();

        txtNumberRoom.clear();
        txtNumberRoom.setEditable(true);
        txtNumberRoom.setDisable(false);
    }

    public void returnUpdateRoomMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("RoomUI");
    }

    public void findRoom(ActionEvent actionEvent) {
        try {
            Integer roomNumber = Integer.valueOf(txtNumberRoom.getText());
            Optional<Room> roomFound = findRoomUseCase.findOneRoom(roomNumber);
            System.out.println(roomFound);
            room = roomFound.get();
            displayRoomData();
        } catch (Exception e){
            showAlert("Erro!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void displayRoomData(){

        List<RoomStatus> statusOptions = Arrays.asList(RoomStatus.values());
        cbStatusRoom.setItems(FXCollections.observableArrayList(statusOptions));
        cbStatusRoom.setValue(room.getRoomStatus());

        txtNumberRoom.setEditable(false);
        txtNumberRoom.setDisable(true);
    }

    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
