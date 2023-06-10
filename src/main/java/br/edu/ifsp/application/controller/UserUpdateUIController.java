package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.user.UserStatus;
import br.edu.ifsp.domain.entities.user.UserType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static br.edu.ifsp.application.main.Main.findUserUseCase;
import static br.edu.ifsp.application.main.Main.updateUserUseCase;

public class UserUpdateUIController {

    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<UserStatus> cbStatus;
    @FXML
    private ComboBox<UserType> cbType;
    private User user;


    public void updateUser(ActionEvent actionEvent){
        user.setTypeUser(cbType.getValue());
        user.setStatusUser(cbStatus.getValue());
        updateUserUseCase.updateUser(user);
        String messagen = "Usuário atualizado com sucesso!";
        showAlert("Success!", messagen, Alert.AlertType.INFORMATION);
        clearData();
    }

    public  void findUser(ActionEvent actionEvent){
        try {
            Optional<Optional<User>> userFound = findUserUseCase.findOne(txtCpf.getText());
            user = userFound.get().get();
            displayUserData();
        } catch (Exception e) {
            showAlert("Erro!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void displayUserData() {
        txtName.setText(user.getNameUser());

        List<UserStatus> statusOptions = Arrays.asList(UserStatus.values());
        cbStatus.setItems(FXCollections.observableArrayList(statusOptions));
        cbStatus.setValue(user.getStatusUser());

        List<UserType> typeOptions = Arrays.asList(UserType.values());
        cbType.setItems(FXCollections.observableArrayList(typeOptions));
        cbType.setValue(user.getTypeUser());

        txtCpf.setEditable(false);
        txtCpf.setDisable(true);
    }

    public void clearUserData(ActionEvent actionEvent) {
        clearData();
    }
    private void clearData() {
        txtName.clear();
        cbStatus.getSelectionModel().clearSelection();
        cbType.getSelectionModel().clearSelection();

        txtCpf.clear();
        txtCpf.setEditable(true);
        txtCpf.setDisable(false);
    }

    public void returnUserMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("UserUI");
    }

    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
