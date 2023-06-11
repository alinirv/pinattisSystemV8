package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.entities.room.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static br.edu.ifsp.application.main.Main.listProductsUseCase;

public class ProductListUIController {
    @FXML
    private TableView<Product> tableViewProduct;
    @FXML
    private TableColumn<Product, String> cProductName;
    @FXML
    private TableColumn<Product, String> cProductPrice;
    @FXML
    private TableColumn<Product, String> cProductStatus;

    private ObservableList<Product> tableData;

    @FXML
    private void initialize(){
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }
    private void bindTableViewToItemsList() {
        tableData = FXCollections.observableArrayList();
        tableViewProduct.setItems(tableData);
    }
    private void bindColumnsToValueSources() {
        cProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cProductStatus.setCellValueFactory(new PropertyValueFactory<>("productStatus"));
    }

    private void loadDataAndShow() {
        List<Product> Product = listProductsUseCase.findAll();
        tableData.clear();
        tableData.addAll(Product);
    }
    public void exportTableToCSV(ActionEvent actionEvent) {
        try (FileWriter writer = new FileWriter("products.csv")) {
            for (Product product : tableData) {
                writer.write(product.getName() + "," + product.getPrice() +  "," + product.getProductStatus() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void returnProductMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ProductUI");
    }
}
