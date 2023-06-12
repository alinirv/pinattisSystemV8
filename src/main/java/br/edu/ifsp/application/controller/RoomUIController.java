package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.autenticationUserUseCase;

public class RoomUIController {
    public void returnRoomMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

    public void createRoom(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("RoomCreateUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void updateRoom(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("RoomUpdateUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void listRoom(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("RoomListUI");
    }

    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
