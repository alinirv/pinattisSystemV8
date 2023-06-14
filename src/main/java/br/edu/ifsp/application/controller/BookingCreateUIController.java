package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.booking.BookingStatus;
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.entities.room.RoomStatus;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.edu.ifsp.application.main.Main.*;

public class BookingCreateUIController {

    @FXML
    private DatePicker dpDateInit;
    @FXML
    private DatePicker dpDateFinsh;
    @FXML
    private ComboBox<String> cbCategory;
    @FXML
    private ComboBox<Integer> cbRoom;
    @FXML
    private ComboBox<String> cbService;
    @FXML
    private Label lbSuccess;
    private List<Category> categoryList;
    private Category category;
    private Booking booking;
    private List<Room> selectedRoom;

    @FXML
    public void initialize() {
        List<Category> allCategory = findListCategory();
               allCategory.forEach(category -> cbCategory.getItems().add(category.getNameCategory()));
        cbCategory.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                List<Integer> selectedRoom = new ArrayList<>();
                findListCategory().stream()
                        .filter(category -> category.getNameCategory().equals(newValue))
                        .flatMap(category -> category.getRoomList().stream())
                        .map(Room::getNumberRoom)
                        .forEach(selectedRoom::add);

                cbRoom.setItems(FXCollections.observableArrayList(selectedRoom));

                Stream<CategoryPrice> service = findListCategory().stream()
                        .filter(category -> category.getNameCategory().equals(newValue)).map(Category::getPrice);

               /*Optional<Category> c = findListCategory().stream()
                        .filter(category -> category.getNameCategory().equals(newValue))
                        .findFirst();
                cbService.setItems(FXCollections.observableArrayList(c.get().get);*/

            }
        });
    }

    public void createBooking(ActionEvent actionEvent) throws IOException {
        getEntityFromView();
        createBookingUseCase.insert(booking);
        displaysSuccessMessage();
    }

    private void getEntityFromView() {

        booking = new Booking(cbRoom.getValue(),cbCategory.getValue(),cbService.getValue(),
                dpDateInit.getValue(),dpDateInit.getValue(),dpDateFinsh.getValue(), BookingStatus.OPEN);
    }


    private List<Category> findListCategory(){
        return listCategoryUseCase.findAllCategory();
    }

    private void displaysSuccessMessage(){
        lbSuccess.setVisible(true);
        lbSuccess.setManaged(true);
    }
    public void clearData(ActionEvent actionEvent) throws IOException {
        dpDateInit.setValue(null);
        dpDateFinsh.setValue(null);
        cbCategory.getSelectionModel().clearSelection();
        cbRoom.getSelectionModel().clearSelection();
        cbService.getSelectionModel().clearSelection();
        lbSuccess.setVisible(false);
        lbSuccess.setManaged(false);
    }
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
