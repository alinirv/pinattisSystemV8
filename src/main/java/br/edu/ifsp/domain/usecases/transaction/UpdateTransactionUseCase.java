package br.edu.ifsp.domain.usecases.transaction;


import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateTransactionUseCase {
    private TransactionDAO transactionDAO;

    public UpdateTransactionUseCase(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public Boolean update(Transaction transaction){
        Validator<Transaction> validator = new TransactionInputRequestValidator();
        Notification notification = validator.validate(transaction);

        if (notification.hasErros()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        Integer id = transaction.getId();
        if (transactionDAO.findOne(id).isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }

        return transactionDAO.update(transaction);
    }
}
