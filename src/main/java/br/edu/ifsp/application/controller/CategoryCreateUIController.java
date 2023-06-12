package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryStatus;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.entities.user.UserStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.edu.ifsp.application.main.Main.*;

public class CategoryCreateUIController {
    @FXML
    private TextField txtNameCategory;
    @FXML
    private TextField txtPreco1hora;
    @FXML
    private TextField txtPreco2hora;
    @FXML
    private TextField txtPrecoPerNoite;
    @FXML
    private TextField txtPrecoHoraAdicional;
    @FXML
    private ComboBox<CategoryStatus> cbCategoryStatus;
    @FXML
    private TextField txtNumberRoom;
    @FXML
    private TableView<Room> tbViewCategoryRoom;
    @FXML
    private TableColumn<Room, String> cNumberRoom;
    @FXML
    private TableColumn<Room, String> cStatusRoom;
    @FXML
    private ComboBox<Room> cbNumberRoom;
    private ObservableList<Room> tableData;
    @FXML
    private Label lbSuccess;
    private Category category;

    @FXML
    public void initialize() {
        List<Room> allRoom = getUnassociatedRooms();
        cbNumberRoom.setItems(FXCollections.observableArrayList(allRoom));


        cbCategoryStatus.getItems().addAll(CategoryStatus.values());
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }

    private void bindTableViewToItemsList() {
        tableData = FXCollections.observableArrayList();
        tbViewCategoryRoom.setItems(tableData);
    }

    private void bindColumnsToValueSources() {
        cNumberRoom.setCellValueFactory(new PropertyValueFactory<>("numberRoom"));
        cStatusRoom.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
    }

    private void loadDataAndShow() {
        List<Room> Room = findRoomUseCase.findAll();
        tableData.clear();
        tableData.addAll(Room);
    }

    public void createCategory(ActionEvent actionEvent) throws IOException {
        getEntityFromView();
        createCategoryUseCase.insert(category);
        displaysSuccessMessage();
    }

    private void getEntityFromView() {
        CategoryStatus selectedStatus = cbCategoryStatus.getValue();
        category = new Category();
    }

    private void displaysSuccessMessage() {
        lbSuccess.setVisible(true);
        lbSuccess.setManaged(true);

    }

    public List<Room> getUnassociatedRooms() {
        List<Room> allRooms = findRoomUseCase.findAll();
        List<Room> nonAssociatedRooms = new ArrayList<>();
        for (Room room : allRooms) {
            if (!roomAssociatedCategory(room)) {
                nonAssociatedRooms.add(room);
            }
        }
        return nonAssociatedRooms;
    }

    private boolean roomAssociatedCategory(Room room) {
        List<Category> categories = listCategoriesUseCase.findAllCategory();
        for (Category category : categories) {
            if (category.getRoomList().contains(room)) {
                return true;
            }
        }
        return false;
    }

    public void newCategory(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("CategoryCreateUI");

    }

    public void categoryReturnMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("CategoryUI");
    }
}
