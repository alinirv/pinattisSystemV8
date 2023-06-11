package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ProductUIController {


    public void returnProductMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("MenuUI");
    }

    public void createProduct(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ProductCreateUI");
    }

    public void updateProduct(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ProductUpdateUI");
    }

    public void listProduct(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("ProductListUI");
    }
}
