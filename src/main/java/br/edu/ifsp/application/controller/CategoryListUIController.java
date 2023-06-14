package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.user.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static br.edu.ifsp.application.main.Main.findUserUseCase;
import static br.edu.ifsp.application.main.Main.listCategoryUseCase;

public class CategoryListUIController {

    @FXML
    private TableView<Category> tableViewCategory;
    @FXML
    private TableColumn<Category, String> cCategoryName;
    @FXML
    private TableColumn<Category, List<String>> cCategoryRoom;
    @FXML
    private TableColumn<Category,Double> c1Hour;
    @FXML
    private TableColumn<Category,Double> c2Hour;
    @FXML
    private TableColumn<Category,Double> cAdditional;
    @FXML
    private TableColumn<Category,Double> cOverNight;
    @FXML
    private TableColumn<Category,String> cCategoryStatus;
    private ObservableList<Category> tableData;


    @FXML
    private void initialize() {
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }

    private void bindTableViewToItemsList() {
        tableData = FXCollections.observableArrayList();
        tableViewCategory.setItems(tableData);
    }

    private void bindColumnsToValueSources() {
        cCategoryName.setCellValueFactory(new PropertyValueFactory<>("nameCategory"));
        cCategoryRoom.setCellValueFactory(new PropertyValueFactory<>("roomList"));
        c1Hour.setCellValueFactory(new PropertyValueFactory<>("price"));
        c2Hour.setCellValueFactory(new PropertyValueFactory<>("price"));
        cAdditional.setCellValueFactory(new PropertyValueFactory<>("price"));
        cOverNight.setCellValueFactory(new PropertyValueFactory<>("price"));
        cCategoryStatus.setCellValueFactory(new PropertyValueFactory<>("categoryStatus"));
    }

    private void loadDataAndShow() {
        List<Category> category = listCategoryUseCase.findAllCategory();
        tableData.clear();
        tableData.addAll(category);
    }
    public void returnCategoryMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("CategoryUI");
    }
    public void exportTableToCSV(ActionEvent actionEvent) {
        try (FileWriter writer = new FileWriter("category.csv")) {
            for (Category category: tableData) {
                writer.write(category.getNameCategory() + "," + category.getRoomList() +
                        ","+ category.getPriceBy(CategoryPrice.ONE_HOUR) +
                        ","+ category.getPriceBy(CategoryPrice.TWO_HOURS) +
                        ","+category.getPriceBy(CategoryPrice.ALL_NIGHT)+
                        ","+category.getPriceBy(CategoryPrice.ADDITIONAL_HOUR)+
                        ','+category.getCategoryStatus().toString()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

