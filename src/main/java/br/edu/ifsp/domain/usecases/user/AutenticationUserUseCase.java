package br.edu.ifsp.domain.usecases.user;

import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.Optional;

public class AutenticationUserUseCase {

    private UserDAO userDAO;
    private Optional<User> user;

    public AutenticationUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void login(String cpf, String password) {
        if (Validator.nullOrEmpty(cpf) || Validator.nullOrEmpty(password))
            throw new IllegalArgumentException("CPF ou senha  can not be null or empty.");

        user = userDAO.findOne(cpf);

        if (validatorCredentials(user.get())) {
            Session.getInstance();
            Session.getInstance().setCurrentUser(user.get());

        }
    }

    public void logout() {
        Session.getInstance().setCurrentUser(null);
    }

    public boolean validatorCredentials(User user) {
        if (user.getCpfUser().equals(user.getCpfUser()) && user.getPasswordUser().equals(user.getPasswordUser())) {
            return true;
        }
        throw new IllegalArgumentException("Usuário ou senha incorreto!.");
    }

    public void verifyAdmin(){
        if (!Session.getInstance().getCurrentUser().getTypeUser().isAdmin()) {
            throw new EntityAlreadyExistsException("Desculpe, você não tem permissão para executar esta função no sistema.");
        }
    }

    public boolean validatorPassword(String cpf, String password) {

        User userChecked = userDAO.findOne(cpf).get();

        if (userChecked.getPasswordUser().equals(password)) {
            return true;
        }
        throw new IllegalArgumentException("Senha incorreta!.");
    }

    public boolean verifyPassword(String password) {
        int passwordLength = 6;
        boolean containsLowercaseLetter = false;
        boolean containsCapitalLetter = false;
        boolean containsDigit = false;

        if (password.length() < passwordLength) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsCapitalLetter = true;
            } else if (Character.isLowerCase(c)) {
                containsLowercaseLetter = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            }

            if (containsCapitalLetter && containsLowercaseLetter && containsDigit) {
                return true;
            }
        }

        return false;
    }
}
