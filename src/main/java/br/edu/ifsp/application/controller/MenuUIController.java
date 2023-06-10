package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.usecases.user.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.autenticationUserUseCase;

public class MenuUIController {
    @FXML
    private Menu mnUser;


    @FXML
    private void initialize() {
        String user = Session.getInstance().getCurrentUser().getNameUser();
        mnUser.setText("Usuário: " + user);
    }

    public void signOut(ActionEvent actionEvent) throws IOException {
        autenticationUserUseCase.logout();
        WindowLoader.setRoot("MainUI");
    }

    public void changePassword(ActionEvent actionEvent)throws IOException{
        WindowLoader.setRoot("UserUpdatePasswordUI");
    }

    public void bookingMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingUI");
    }
    public void userMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("UserUI");
    }

    public void cashierMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("CashierUI");
    }
    public void categoryMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("CategoryUI");
    }

    public void productMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ProductUI");
    }
    public void roomMenu(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("RoomUI");
    }
}
