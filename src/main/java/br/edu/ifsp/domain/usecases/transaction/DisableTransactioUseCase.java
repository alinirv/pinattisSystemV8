package br.edu.ifsp.domain.usecases.transaction;

import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class DisableTransactioUseCase {
    private TransactionDAO transactionDAO;

    public DisableTransactioUseCase(TransactionDAO transactionDAO){
        this.transactionDAO = transactionDAO;
    }

    public boolean disableTransaction(Integer id){
        if (id == null || transactionDAO.findOne(id).isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }
        return transactionDAO.disableByKey(id);
    }

    public boolean disableTransaction(Transaction transaction){
        if (transaction == null || transactionDAO.findOne(transaction.getId()).isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }
        return transactionDAO.delete(transaction);
    }
}
