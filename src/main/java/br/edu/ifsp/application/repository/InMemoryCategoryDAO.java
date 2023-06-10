package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.usecases.category.CategoryDAO;

import java.util.*;

public class InMemoryCategoryDAO implements CategoryDAO {
    private static final Map<Integer, Category> db = new LinkedHashMap<>();
    private static int idCounter;

    @Override
    public Integer create(Category category) {
        idCounter++;
        category.setIdCategory(idCounter);
        db.put(idCounter, category);
        return idCounter;
    }

    @Override
    public Optional<Category> findOneCategory(Integer key) {
        if (db.containsKey(key)) {
            return Optional.of(db.get(key));
        }
        return Optional.empty();
    }

    @Override
    public List<Category> findAllCategory() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Category category) {
        Integer id = category.getIdCategory();
        if (db.containsKey(id)) {
            db.replace(id, category);
            return true;
        }
        return false;
    }


    @Override
    public Optional<Category> findOne(Integer key) {
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() {
        return null;
    }


    @Override
    public boolean deleteByKey(Integer key) {
        if (db.containsKey(key)) {
            db.remove(key);
        }
        return false;
    }

    @Override
    public boolean delete(Category category) {

        return deleteByKey(category.getIdCategory());
    }

    @Override
    public Optional<Category> findById(String id) {
        return Optional.empty();
    }
}


