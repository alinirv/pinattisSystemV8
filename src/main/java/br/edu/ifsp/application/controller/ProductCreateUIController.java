package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.entities.product.ProductStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.createProductUseCase;

public class ProductCreateUIController {
    @FXML
    private TextField txtNameProd;
    @FXML
    private TextField txtPrice;
    @FXML
    private ComboBox<ProductStatus> cbProductStatus;
    @FXML
    private Label lbSuccess;
    private Product product;

    @FXML
    public void initialize() {
        cbProductStatus.getItems().addAll(ProductStatus.values());
    }

    public void productReturnMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ProductUI");
    }

    public void createProduct(ActionEvent actionEvent) throws IOException {
        getEntityFromView();
        createProductUseCase.insert(product);
        displaysSuccessMessage();
    }

    private void displaysSuccessMessage() {
        lbSuccess.setVisible(true);
        lbSuccess.setManaged(true);
    }

    private void getEntityFromView() {
        ProductStatus selectedStatus = cbProductStatus.getValue();

        product = new Product(txtNameProd.getText(), Double.parseDouble(txtPrice.getText()), selectedStatus);
    }
}
