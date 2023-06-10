package br.edu.ifsp.domain.usecases.user;

import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateUserUseCase {

    private UserDAO userDAO;

    public CreateUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Integer insert(User user){

            Validator<User> validator = new UserInpuntRequestValidator();
            Notification notification = validator.validate(user);

            if (notification.hasErros()){
                throw new IllegalArgumentException(notification.errorMessage());
            }
            String cpf = user.getCpfUser();
            if(userDAO.findOne(cpf).isPresent())
                throw new EntityAlreadyExistsException("This CPF is already in use.");

            return userDAO.create(user);

    }
}
