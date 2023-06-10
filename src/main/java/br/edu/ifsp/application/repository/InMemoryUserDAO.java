package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.user.UserDAO;

import java.util.*;

public class InMemoryUserDAO implements UserDAO {

    private static final Map<Integer, User> db = new LinkedHashMap<>();
    private static int idCounter;

    @Override
    public Integer create(User user) {
        idCounter++;
        user.setIdUser(idCounter);
        db.put(idCounter, user);
        return idCounter;
    }

    @Override
    public Optional<User> findOne(Integer key) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findOne(String cpf) {
        return db.values().stream()
                .filter(user -> user.getCpfUser().equals(cpf))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return  new ArrayList<>(db.values());
    }

    @Override
    public boolean update(User user) {
        Integer id = user.getIdUser();
        if (db.containsKey(id)){
            db.replace(id,user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        if (db.containsKey(key)){
            db.remove(key);
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        return deleteByKey(user.getIdUser());
    }

}
