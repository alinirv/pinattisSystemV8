package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class CashierUIController {
    public void backCashier(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }
}
