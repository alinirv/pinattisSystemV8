package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class RoomUIController {
    public void returnRoomMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

    public void createRoom(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("RoomCreateUI");
    }

    public void updateRoom(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("RoomUpdateUI");
    }

    public void listRoom(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("RoomListUI");
    }
}
