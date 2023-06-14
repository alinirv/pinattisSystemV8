package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.entities.user.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static br.edu.ifsp.application.main.Main.*;

public class BookingUpdateUIController {
    @FXML
    private TextField txtBookingRoom;
    @FXML
    private DatePicker dpDateInit;
    @FXML
    private DatePicker dpDateEnd;
    @FXML
    private ComboBox cbCategory;
    @FXML
    private ComboBox cbRoom;
    @FXML
    private ComboBox cbService;
    @FXML
    private CheckBox ckCancel;
    private Booking myBbooking;

    public void updateBooking(ActionEvent actionEvent){
        if (!myBbooking.isFinished(myBbooking) ){
            if(ckCancel.isSelected()){
                myBbooking.toCanceled(myBbooking);
                upDateBookingUseCase.updateBooking(myBbooking);
            }
            myBbooking.setNameCategory(cbCategory.getValue().toString());
            myBbooking.setStartDateBooking(dpDateInit.getValue().atStartOfDay());
            myBbooking.setFinishDateBooking(dpDateEnd.getValue().atStartOfDay());
            myBbooking.setNameCategory(cbCategory.getValue().toString());
            myBbooking.setNumberRoom((Integer) cbRoom.getValue());
            myBbooking.setService(cbService.getValue().toString());
            upDateBookingUseCase.updateBooking(myBbooking);
            String messagen = "Reserva atualizada com sucesso!";
            showAlert("Success!", messagen, Alert.AlertType.INFORMATION);
            clearData();
        }else {
            String messagen = "Reserva já finalizada!";
            showAlert("Error!", messagen, Alert.AlertType.ERROR);
            clearData();
        }


    }



    public  void findBooking(ActionEvent actionEvent){
        try {
            Optional<Booking> bookingFound = findBookingUseCase.findOneBooking(Integer.valueOf(txtBookingRoom.getText()));
            myBbooking = bookingFound.get();
            displayBookingData();
        } catch (Exception e) {
            showAlert("Erro!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void displayBookingData() {
        dpDateInit.setValue(myBbooking.getStartDateBooking().toLocalDate());
        dpDateEnd.setValue(myBbooking.getFinishDateBooking().toLocalDate());
        cbCategory.setValue(myBbooking.getNameCategory());
        cbRoom.setValue(myBbooking.getNumberRoom());
        cbService.setValue(myBbooking.getService());
        setDisplayView();

    }

    private void setDisplayView(){
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

            }


        });
        cbService.setItems(FXCollections.observableArrayList(CategoryPrice.values()));
    }

    private List<Category> findListCategory(){
        return listCategoryUseCase.findAllCategory();
    }

    public void clearBookingData(ActionEvent actionEvent) {
        clearData();
    }
    private void clearData() {
        txtBookingRoom.clear();
        dpDateInit.setValue(null);
        dpDateEnd.setValue(null);
        cbCategory.getSelectionModel().clearSelection();
        cbRoom.getSelectionModel().clearSelection();
        cbService.getSelectionModel().clearSelection();
        ckCancel.setSelected(false);
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
