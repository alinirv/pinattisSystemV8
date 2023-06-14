package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.room.Room;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static br.edu.ifsp.application.main.Main.*;

public class CategoryCreateUIController {
    @FXML
    private TextField txtNameCategory;
    @FXML
    private TextField txt1Hour;
    @FXML
    private TextField txt2Hour;
    @FXML
    private TextField txtOverNight;
    @FXML
    private TextField txtAdditional;
    @FXML
    private ComboBox<Integer> cbNumberRoom;
    @FXML
    private Label lbSuccess;
    private Category category;
    private List<Room> selectedRoom;
    private CategoryPrice prices;

    @FXML
    public void initialize() {
        List<Integer> allRoom = getUnassociatedRooms().stream().map(Room::getNumberRoom).toList();
        cbNumberRoom.setItems(FXCollections.observableArrayList(allRoom));
    }

    public void createCategory(ActionEvent actionEvent) throws IOException {
        getEntityFromView();
        createCategoryUseCase.insert(category);
        displaysSuccessMessage();
    }

    private void getEntityFromView() {
        category = new Category(txtNameCategory.getText(),selectedRoom);
        category.setCategoryPrice(CategoryPrice.ONE_HOUR,Double.valueOf(txt1Hour.getText()));
        category.setCategoryPrice(CategoryPrice.TWO_HOURS,Double.valueOf(txt2Hour.getText()));
        category.setCategoryPrice(CategoryPrice.ALL_NIGHT,Double.valueOf(txtOverNight.getText()));
        category.setCategoryPrice(CategoryPrice.ADDITIONAL_HOUR,Double.valueOf(txtAdditional.getText()));
    }

    public void selectedRoom(ActionEvent actionEvent) throws IOException {
        if (selectedRoom==null){
            selectedRoom =new ArrayList<>();
        }
        getUnassociatedRooms().stream()
                .filter(room -> room.getNumberRoom() == cbNumberRoom.getValue())
                .forEach(selectedRoom::add);
        cbNumberRoom.getSelectionModel().clearSelection();
    }

    private void displaysSuccessMessage() {
        lbSuccess.setVisible(true);
        lbSuccess.setManaged(true);

    }


    public List<Room> getUnassociatedRooms() {
        return  findRoomUseCase.findAll().stream().filter(this::hasNoCategoryFor).toList();
    }

    private boolean hasNoCategoryFor(Room room) {
        return listCategoryUseCase.findAllCategory().stream().anyMatch(c ->c.getRoomList().contains(room));
    }
    public void clearData(ActionEvent actionEvent) throws IOException {

        txtNameCategory.clear();
        txt1Hour.clear();
        txt2Hour.clear();
        txtOverNight.clear();
        txtAdditional.clear();
        cbNumberRoom.getSelectionModel().clearSelection();
        lbSuccess.setVisible(false);
        lbSuccess.setManaged(false);
    }

    public void categoryReturnMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("CategoryUI");
    }
}
