package br.edu.ifsp.application.repository;


import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.usecases.transaction.TransactionDAO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryTransactionDAO implements TransactionDAO {

    private static final Map<Integer, Transaction> db = new LinkedHashMap<>();

    private static int idCounter;
    @Override
    public Integer create(Transaction transaction) {
        idCounter++;
        transaction.setId(idCounter);
        db.put(idCounter, transaction);
        return idCounter;
    }

    @Override
    public Optional<Transaction> findOne(Integer key) {

        if (db.containsKey(key)){
            return Optional.of(db.get(key));
        }
        return Optional.empty();
    }

    @Override
    public List<Transaction> findAll() {

        return  new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Transaction transaction) {
        Integer id = transaction.getId();
        if (db.containsKey(id)){
            db.replace(id, transaction);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        return false;
    }

    @Override
    public boolean disableByKey(Integer key) {
        return false;
    }

    @Override
    public boolean delete(Transaction transaction) {

        return disableByKey(transaction.getId());
    }
}
