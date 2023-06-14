package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static br.edu.ifsp.application.main.Main.findBookingUseCase;

public class BookingListUIController {
    @FXML
    private TableView<Booking> tableView;
    @FXML
    private TableColumn<Booking,String> cCategory;
    @FXML
    private TableColumn<Booking,String> cRoom;
    @FXML
    private TableColumn<Booking,String> cService;
    @FXML
    private TableColumn<Booking,LocalDateTime> cDateInit;
    @FXML
    private TableColumn<Booking,LocalDateTime> cDateFinish;
    @FXML
    private TableColumn<Booking,String> cStatus;
    private ObservableList<Booking> tableData;

    @FXML
    private void initialize() {
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }
    private void bindColumnsToValueSources() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void bindTableViewToItemsList() {
        cCategory.setCellValueFactory(new PropertyValueFactory<>("nameCategory"));
        cRoom.setCellValueFactory(new PropertyValueFactory<>("numberRoom"));
        cDateInit.setCellValueFactory(new PropertyValueFactory<>("startDateBooking"));
        cDateFinish.setCellValueFactory(new PropertyValueFactory<>("finishDateBooking"));
        cStatus.setCellValueFactory(new PropertyValueFactory<>("bookingStatus"));
        cService.setCellValueFactory(new PropertyValueFactory<>("service"));
    }

    private void loadDataAndShow() {
        List<Booking> Booking= findBookingUseCase.findAll();
        tableData.clear();
        tableData.addAll(Booking);
    }

    public void returnMenuBookingUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingUI");
    }
    public void exportTableToCSV(ActionEvent actionEvent) {
        try (FileWriter writer = new FileWriter("booking.csv")) {
            for (Booking booking : tableData) {
                writer.write(booking.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
