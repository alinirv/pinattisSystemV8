package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

public class BookingUIController {
    public void returnMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("SalesManagementUI");
    }

    public void createBooking(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingCreateUI");
    }

    public void updateBooking(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingUpdateUI");
    }

    public void listBooking(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingListUI");
    }

    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}
