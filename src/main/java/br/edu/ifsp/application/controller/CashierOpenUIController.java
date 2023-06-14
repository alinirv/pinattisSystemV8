package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.cashier.Cashier;
import br.edu.ifsp.domain.entities.cashier.CashierStatus;
<<<<<<< HEAD
import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.transaction.Transaction2;
=======
import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.entities.room.RoomStatus;
import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.transaction.Transaction2;
import br.edu.ifsp.domain.usecases.user.Session;
>>>>>>> 18e9541a1c8100156c955b19ce5928bd57ea746e
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
<<<<<<< HEAD
import java.util.List;
import java.util.Optional;
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
>>>>>>> 18e9541a1c8100156c955b19ce5928bd57ea746e

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
<<<<<<< HEAD
=======
    private TableColumn <Cashier, Integer> cItem;
    @FXML
    private TableColumn <Cashier, Integer> cQuantity;
    @FXML
    private TableColumn <Cashier, Integer> cProduct;
    @FXML
    private TableColumn <Cashier, Integer> cValue;
    @FXML
    private TableColumn <Cashier, Integer> cTotal;
    @FXML
>>>>>>> 18e9541a1c8100156c955b19ce5928bd57ea746e
    private TextField txtAmount;
    @FXML
    private ComboBox<Integer> cbBooking;
    @FXML
    private ComboBox<String> cbProduct;
    private Cashier cashier;
<<<<<<< HEAD
    private Transaction transaction;
=======
    private Transaction2 transaction;
>>>>>>> 18e9541a1c8100156c955b19ce5928bd57ea746e


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

<<<<<<< HEAD
        /* Optional<Optional<Product>> product = listProductsUseCase.findByName(cbProduct.getValue());
         transaction.addProducts(product.get().get());*/
         cbProduct.getSelectionModel().clearSelection();
         getTotal();
=======
         Optional<Optional<Product>> product = listProductsUseCase.findByName(cbProduct.getValue());
         transaction.addProducts(product.get().get());

>>>>>>> 18e9541a1c8100156c955b19ce5928bd57ea746e
    }

    public void getBooking(ActionEvent actionEvent)throws IOException{
        Optional<Booking> booking = findBookingUseCase.findOneBooking(cbBooking.getValue());
        // adiciopnar a reserva
    }

    public void initiateCheckout(ActionEvent actionEvent)throws IOException{
         if (transaction == null)
<<<<<<< HEAD
             transaction =new Transaction();
         findItems();
    }

    public void getTotal(){
         /*transaction.setAmount(transaction.calculateTotalValue());
         txtAmount.setText(String.valueOf(transaction.getAmount()));*/
    }


=======
             transaction =new Transaction2();
         findItems();
    }

>>>>>>> 18e9541a1c8100156c955b19ce5928bd57ea746e
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
