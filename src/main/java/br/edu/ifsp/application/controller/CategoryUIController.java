package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryUIController {
    public void voltarCategoryMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

}

