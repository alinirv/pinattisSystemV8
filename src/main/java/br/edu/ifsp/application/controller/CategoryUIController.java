package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.autenticationUserUseCase;

public class CategoryUIController {
    public void returnCategoryMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

    public void createCategory(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("CategoryCreateUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void updateCategory(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("CategoryUpdateUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    public void listCategory(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("CategoryListUI");
    }
    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
