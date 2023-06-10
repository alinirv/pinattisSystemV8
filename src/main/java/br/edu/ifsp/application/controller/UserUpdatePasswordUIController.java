package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.views.WindowLoader;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.user.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.autenticationUserUseCase;
import static br.edu.ifsp.application.main.Main.updateUserUseCase;

public class UserUpdatePasswordUIController {
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtName;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField txtNewPassword;

    private User user;

    private User loggedUser;
    @FXML
    private void initialize() {
        displayUserData();
    }

    public void updatePasswordUser(ActionEvent actionEvent){
        try {
            if (verifyNewPassword()){
                String cpf = txtCpf.getText();
                String password = pfPassword.getText();
                if (autenticationUserUseCase.validatorPassword(cpf, password)) {
                    loggedUser.setPasswordUser(txtNewPassword.getText());
                    updateUserUseCase.updateUser(loggedUser);
                    String messagen = "Senha alterada com sucesso!";
                    showAlert("Success!", messagen, Alert.AlertType.INFORMATION);
                    //###########Deletar o teste
                    System.out.println(loggedUser);
                    clearData();
                }
            }
        }catch(Exception e){
            showAlert("Atenção!", e.getMessage(), Alert.AlertType.ERROR);
        }

    }
    private Boolean verifyNewPassword(){
        if (!autenticationUserUseCase.verifyPassword(txtNewPassword.getText())) {
            String messagen = "\"Por favor, crie uma senha que atenda aos seguintes critérios:\n" +
                    "\n" +
                    "A senha deve ter no mínimo 6 caracteres.\n" +
                    "A senha deve conter pelo menos uma letra minúscula.\n" +
                    "A senha deve conter pelo menos uma letra maiúscula.\n" +
                    "A senha deve conter pelo menos um dígito numérico.";
            showAlert("Atenção!", messagen, Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    private void displayUserData() {
        loggedUser = Session.getInstance().getCurrentUser();
        txtCpf.setText(loggedUser.getCpfUser());
        txtName.setText(loggedUser.getNameUser());
    }

    private void clearData() {
        txtName.clear();
        txtCpf.clear();
        pfPassword.clear();
        txtNewPassword.clear();
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
