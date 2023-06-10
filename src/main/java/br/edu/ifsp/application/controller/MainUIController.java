package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.autenticationUserUseCase;

public class MainUIController {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPassword;

    public void autenticationUI(ActionEvent actionEvent) {
        try {
            autenticationUserUseCase.login(txtUser.getText(), txtPassword.getText());
            WindowLoader.setRoot("MenuUI");
        }catch (Exception e) {
            showAlert("Erro!", e.getMessage(), Alert.AlertType.ERROR);
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

