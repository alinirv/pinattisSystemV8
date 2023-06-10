package br.edu.ifsp.domain.usecases.user;

import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.Optional;

public interface UserDAO extends DAO<User, Integer> {
    public Optional<User> findOne(String cpf);
}
