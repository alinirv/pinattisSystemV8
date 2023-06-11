package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.entities.product.ProductStatus;
import br.edu.ifsp.domain.entities.user.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static br.edu.ifsp.application.main.Main.listProductsUseCase;
import static br.edu.ifsp.application.main.Main.updateProductUseCase;

public class ProductUpdateUIController {
    @FXML
    private TextField txtProductName;
    @FXML
    private TextField txtProductPrice;

    @FXML
    private ComboBox<ProductStatus> cbProductStatus;
    private Product product;
    public void updateProduct(ActionEvent actionEvent) {
        product.setName(txtProductName.getText());
        product.setPrice(Double.parseDouble(txtProductPrice.getText()));
        product.setProductStatus(cbProductStatus.getValue());
        updateProductUseCase.update(product);
        String messagen = "Produto atualizado com sucesso!";
        showAlert("Success!", messagen, Alert.AlertType.INFORMATION);
        clearData();
    }
    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void clearProductData(ActionEvent actionEvent) {
        clearData();
    }

    private void clearData() {
        txtProductName.clear();
        txtProductPrice.clear();
        cbProductStatus.getSelectionModel().clearSelection();

        txtProductName.clear();
        txtProductName.setEditable(true);
        txtProductName.setDisable(false);

        txtProductPrice.clear();
        txtProductPrice.setEditable(true);
        txtProductPrice.setDisable(false);
    }

    public void returnProductMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ProductUI");
    }

    public void findProduct(ActionEvent actionEvent) {
        try {
            String productName = txtProductName.getText();
            Optional<Optional<Product>> productFound = listProductsUseCase.findByName(productName);
            System.out.println(productFound);
            product = productFound.get().get();
            displayProductData();
        } catch (Exception e){
            showAlert("Erro!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void displayProductData() {
        txtProductName.setText(product.getName());
        txtProductPrice.setText(String.valueOf(product.getPrice()));

        List<ProductStatus> statusOptions = Arrays.asList(ProductStatus.values());
        cbProductStatus.setItems(FXCollections.observableArrayList(statusOptions));
        cbProductStatus.setValue(product.getProductStatus());
    }
}
