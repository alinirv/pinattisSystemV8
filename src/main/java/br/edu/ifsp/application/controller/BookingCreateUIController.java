package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.entities.room.RoomStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.util.List;

public class BookingCreateUIController {

    @FXML
    private DatePicker dpDate;
    @FXML
    private ComboBox<Category> cbCategory;
    @FXML
    private ComboBox<Room> cbRoom;
    @FXML
    private ComboBox<CategoryPrice> cbService;
    private List<Category> categoryList;
    private Category category;
    private Booking booking;

    @FXML
    public void initialize() {
        //cbCategory.getItems().addAll(category.getNameCategory());
        cbRoom.getItems().addAll(category.getRoomList());
        cbService.getItems().addAll(CategoryPrice.values());
    }


    /*
        private void getEntityFromView() {

        }

        private Category findListCategry(){

        }

        /*

    Room room, Category category, String nameCategory, Double price, LocalDateTime startDateBooking,
                       LocalDateTime finishDateBooking, boolean finished






        private void displaysSuccessMessage(){
            lSuccess.setVisible(true);
            lSuccess.setManaged(true);
        }
        public void clearData(ActionEvent actionEvent) throws IOException {
            txtName.clear();
            txtCpf.clear();
            ckAdmin.setSelected(false);
            txtPassword.clear();

            lSuccess.setVisible(false);
            lSuccess.setManaged(false);

            lPassword.setVisible(false);
            lPassword.setManaged(false);

            txtPassword.setVisible(false);
            txtPassword.setManaged(false);
        }*/
    public void returnMenuBookingUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("BookingUI");
    }
    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
