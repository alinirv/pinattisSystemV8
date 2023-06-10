package br.edu.ifsp.domain.usecases.user;

import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.user.UserType;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.Optional;
import java.util.Scanner;

public class UpdateUserUseCase {
    private UserDAO userDAO;
    private Optional<User> userOptional;

    public UpdateUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Boolean updatePassword(User user) {

        if (Validator.nullOrEmpty(user.getCpfUser()))
            throw new IllegalArgumentException("CPF ou Password can not be null or empty.");
        String cpf = user.getCpfUser();
        userOptional = userDAO.findOne(cpf);

        if (userOptional.isEmpty())
            throw new EntityNotFoundException("User not found.");

        Scanner scanner = new Scanner(System.in);

        System.out.print("New Password: ");
        String password = scanner.nextLine();

        if (Validator.nullOrEmpty(password))
            throw new IllegalArgumentException(" Password can not be null or empty.");
        if (!validatorPassword(password))
            throw new IllegalArgumentException(" The new password does not meet the requirements.");
        userOptional.get().setPasswordUser(password);
        return userDAO.update(userOptional.get());
    }

    public Boolean updateUser(User user) {

        //if (Session.getInstance().getCurrentUser().getTypeUser().isAdmin()) {
        Validator<User> validator = new UserInpuntRequestValidator();
        Notification notification = validator.validate(user);

        if (notification.hasErros()){
            throw new IllegalArgumentException(notification.errorMessage());
        }
        String cpf = user.getCpfUser();
        if(userDAO.findOne(cpf).isEmpty())
            throw new EntityAlreadyExistsException("Usuário não encontrado.");

        return userDAO.update(user);
        //}
        //throw new EntityAlreadyExistsException("Sorry, you do not have permission to perform this function on the system.");
    }

    private boolean validatorPassword(String password) {
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


