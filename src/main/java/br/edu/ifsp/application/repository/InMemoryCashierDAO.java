package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.cashier.Cashier;
import br.edu.ifsp.domain.usecases.cashier.CashierDAO;

import java.util.*;

public class InMemoryCashierDAO implements CashierDAO {
    private static final Map<Integer,Cashier> db = new LinkedHashMap<>();
    private static int idCounter;
    @Override
    public Integer create(Cashier cashier) {
        idCounter++;
        cashier.setIdCashier(idCounter);
        db.put(idCounter, cashier);
        return idCounter;
    }

    @Override
    public Optional<Cashier> findOne(Integer key) {
        return Optional.empty();
    }

    @Override
    public List<Cashier> findAll() {
        return  new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Cashier cashier) {
        Integer id = cashier.getIdCashier();
        if (db.containsKey(id)){
            db.replace(id,cashier);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        return false;
    }

    @Override
    public boolean delete(Cashier type) {
        return false;
    }
}
