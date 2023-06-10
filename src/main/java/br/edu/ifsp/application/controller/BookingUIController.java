package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class BookingUIController {
    public void voltarBookingMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

    public void createBookingMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingCreateUI");
    }

    public void updateBookingMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingUpdateUI");
    }
}
