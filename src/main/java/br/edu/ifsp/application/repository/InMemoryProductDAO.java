package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.usecases.product.ProductDAO;

import java.util.*;

public class InMemoryProductDAO implements ProductDAO {
    private static final Map<Integer, Product> db = new LinkedHashMap<>();
    private static int idCounter;
    @Override
    public Integer create(Product product) {
        idCounter++;
        product.setId(idCounter);
        db.put(idCounter, product);
        return idCounter;
    }

    @Override
    public Optional<Product> findOne(Integer key) {
        if (db.containsKey(key)){
            return Optional.of(db.get(key));
        }
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {

        return  new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Product product) {
        Integer id = product.getId();
        if (db.containsKey(id)){
            db.replace(id, product);
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
    public boolean delete(Product product) {

        return deleteByKey(product.getId());
    }
}
