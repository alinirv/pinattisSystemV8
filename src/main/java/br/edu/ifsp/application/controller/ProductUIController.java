package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.autenticationUserUseCase;

public class ProductUIController {


    public void returnProductMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

    public void createProduct(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("ProductCreateUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void updateProduct(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("ProductUpdateUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void listProduct(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("ProductListUI");
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
