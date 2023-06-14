package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.autenticationUserUseCase;

public class SalesManagementUIController {
    public void returnMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

    public void bookingManagement(ActionEvent actionEvent) throws IOException {

        WindowLoader.setRoot("BookingUI");
    }

    public void cashierManagement(ActionEvent actionEvent) throws IOException {

        WindowLoader.setRoot("CashierOpenUI");
    }

    public void salesReports(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("TransactionUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }
    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
