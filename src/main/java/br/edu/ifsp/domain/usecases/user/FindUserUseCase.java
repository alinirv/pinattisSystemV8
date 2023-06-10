package br.edu.ifsp.domain.usecases.user;

import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.List;
import java.util.Optional;

public class FindUserUseCase {
    private UserDAO userDAO;

    public FindUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<Optional<User>> findOne(String cpf) {
        if (Validator.nullOrEmpty(cpf))
            throw new IllegalArgumentException("Por favor, preencha um CPF válido. ");
        return Optional.ofNullable(userDAO.findOne(cpf));
    }


    public List<User> findAll(){
        return userDAO.findAll();
    }

}
