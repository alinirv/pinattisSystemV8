package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ProductUIController {
    public void voltarProductMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

}
