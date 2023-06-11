package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.room.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static br.edu.ifsp.application.main.Main.findRoomUseCase;

public class RoomListUIController {
    @FXML
    private TableView<Room> tableViewRoom;
    @FXML
    private TableColumn<Room, String> cNumberRoom;
    @FXML
    private TableColumn<Room, String> cStatusRoom;

    private ObservableList<Room> tableData;

    @FXML
    private void initialize(){
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }
    private void bindTableViewToItemsList() {
        tableData = FXCollections.observableArrayList();
        tableViewRoom.setItems(tableData);
    }
    private void bindColumnsToValueSources() {
        cNumberRoom.setCellValueFactory(new PropertyValueFactory<>("numberRoom"));
        cStatusRoom.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
    }

    private void loadDataAndShow() {
        List<Room> Room = findRoomUseCase.findAll();
        tableData.clear();
        tableData.addAll(Room);
    }

    public void exportTableToCSV(ActionEvent actionEvent) {
        try (FileWriter writer = new FileWriter("rooms.csv")) {
            for (Room room : tableData) {
                writer.write(room.getNumberRoom() + "," + room.getRoomStatus() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void returnRoomMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("RoomUI");
    }
}
