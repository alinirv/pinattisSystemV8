package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class BookingCreateUIController {
    public void backBookingCreate(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingUI");
    }
}
