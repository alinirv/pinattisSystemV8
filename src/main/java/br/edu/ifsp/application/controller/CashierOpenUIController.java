package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.cashier.Cashier;
import br.edu.ifsp.domain.entities.cashier.CashierStatus;
import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.transaction.Transaction2;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static br.edu.ifsp.application.main.Main.*;

public class CashierOpenUIController {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtBalance;
    @FXML
    private MenuItem mnUser;
    @FXML
    private MenuItem mnClose;
    @FXML
    private MenuItem mnExit;
    @FXML
    private TextField txtAmount;
    @FXML
    private ComboBox<Integer> cbBooking;
    @FXML
    private ComboBox<String> cbProduct;
    private Cashier cashier;
    private Transaction transaction;


     public void cashierOpened() throws IOException {
         if (findUserUseCase.findOne(txtUser.getText()).isPresent()){
            Optional<Optional<User>> user =findUserUseCase.findOne(txtUser.getText());
            cashier = new Cashier(Double.parseDouble(txtBalance.getText()), CashierStatus.OPENED,user.get().get());
            openCashierUseCase.open(cashier);
            WindowLoader.setRoot("CashierUI");
        }
     }
    public void findItems(){
        List<Integer> allBooking = findBookingUseCase.findAll().stream().map(Booking::getNumberRoom).toList();
        cbBooking.setItems(FXCollections.observableArrayList(allBooking));
        System.out.println(allBooking);
        List<String> allProducts = listProductsUseCase.findAll().stream().map(Product::getName).toList();
        System.out.println(allProducts);
        cbProduct.setItems(FXCollections.observableArrayList(allProducts));

    }

    public void getProduct(ActionEvent actionEvent)throws IOException{

        /* Optional<Optional<Product>> product = listProductsUseCase.findByName(cbProduct.getValue());
         transaction.addProducts(product.get().get());*/
         cbProduct.getSelectionModel().clearSelection();
         getTotal();
    }

    public void getBooking(ActionEvent actionEvent)throws IOException{
        Optional<Booking> booking = findBookingUseCase.findOneBooking(cbBooking.getValue());
        // adiciopnar a reserva
    }

    public void initiateCheckout(ActionEvent actionEvent)throws IOException{
         if (transaction == null)
             transaction =new Transaction();
         findItems();
    }

    public void getTotal(){
         /*transaction.setAmount(transaction.calculateTotalValue());
         txtAmount.setText(String.valueOf(transaction.getAmount()));*/
    }


    public void returnMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("SalesManagementUI");
    }

    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }


}
