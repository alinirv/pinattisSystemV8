package br.edu.ifsp.domain.usecases.transaction;

import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.usecases.utils.DAO;

public interface TransactionDAO extends DAO<Transaction, Integer> {
    boolean disableByKey(Integer key);
}
