package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.autenticationUserUseCase;

public class UserUIController {
    public void returnUserMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

    public void createUser(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("UserCreateUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    public void updateUser(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("UserUpdateUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    public void listUser(ActionEvent actionEvent) throws IOException {
        try {
            autenticationUserUseCase.verifyAdmin();
            WindowLoader.setRoot("UserListUI");
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }
    public void updatePassWord(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("UserUpdatePasswordUI");
    }
    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
