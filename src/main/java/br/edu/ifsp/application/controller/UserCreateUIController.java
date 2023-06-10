package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.user.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.createUserUseCase;
import static br.edu.ifsp.application.main.Main.findUserUseCase;

public class UserCreateUIController {
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtName;
    @FXML
    private CheckBox ckAdmin;
    @FXML
    private TextField txtPassword;
    @FXML
    private Label lPassword;
    @FXML
    private Label lSuccess;
    private User user;

    public void createUser(ActionEvent actionEvent) throws IOException {
        getEntityFromView();
        createUserUseCase.insert(user);
        txtPassword.setText(user.getPasswordUser());
        displaysSuccessMessage();
    }
    public void backUserCreate(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("UserUI");
    }
    private void getEntityFromView() {
        if (ckAdmin.isSelected()) {
            user = new User(txtName.getText(),txtCpf.getText(),UserType.ADMIN);
        }else {
            user = new User(txtName.getText(),txtCpf.getText(),UserType.MAINTAINER);
        }
    }

    private void displaysSuccessMessage(){
        lSuccess.setVisible(true);
        lSuccess.setManaged(true);

        lPassword.setVisible(true);
        lPassword.setManaged(true);

        txtPassword.setVisible(true);
        txtPassword.setManaged(true);
    }

    public void returnUserMenuUI(ActionEvent actionEvent) throws IOException {
        WindowLoader.setRoot("UserUI");
    }
}
