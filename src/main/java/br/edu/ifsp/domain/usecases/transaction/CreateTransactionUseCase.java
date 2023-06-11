package br.edu.ifsp.domain.usecases.transaction;

import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateTransactionUseCase {

    private TransactionDAO transactionDAO;

    public CreateTransactionUseCase(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public Integer insert(Transaction transaction){
        Validator<Transaction> validator = new TransactionInputRequestValidator();
        Notification notification = validator.validate(transaction);

        if (notification.hasErros()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        return transactionDAO.create(transaction);
    }
}
