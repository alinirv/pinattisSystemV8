package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.user.User;
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

import static br.edu.ifsp.application.main.Main.*;

public class UserListUIController {
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> cCpf;
    @FXML
    private TableColumn<User, String> cName;
    @FXML
    private TableColumn<User, String> cType;
    @FXML
    private TableColumn<User, String> cStatus;
    private ObservableList<User> tableData;

   @FXML
    private void initialize() {
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndShow();
    }

    private void bindTableViewToItemsList() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void bindColumnsToValueSources() {
        cName.setCellValueFactory(new PropertyValueFactory<>("nameUser"));
        cCpf.setCellValueFactory(new PropertyValueFactory<>("cpfUser"));
        cType.setCellValueFactory(new PropertyValueFactory<>("typeUser"));
        cStatus.setCellValueFactory(new PropertyValueFactory<>("statusUser"));
    }

    private void loadDataAndShow() {
        List<User> User = findUserUseCase.findAll();
        tableData.clear();
        tableData.addAll(User);
    }

    public void returnUserMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("UserUI");
    }

    public void exportTableToCSV(ActionEvent actionEvent) {
        try (FileWriter writer = new FileWriter("users.csv")) {
            for (User user : tableData) {
                writer.write(user.getNameUser() + "," + user.getCpfUser() + "," + user.getTypeUser() + "," + user.getStatusUser() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
