package br.edu.ifsp.domain.usecases.transaction;

import br.edu.ifsp.domain.entities.transaction.Transaction;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class TransactionInputRequestValidator extends Validator<Transaction> {
    @Override
    public Notification validate(Transaction transaction) {
        Notification notification = new Notification();
        if (transaction == null){
            notification.addError("Transaction is null");
            return notification;
        }

        if(nullOrEmpty(transaction.getBooking().toString())){
            notification.addError("Booking is null or empty");
        }
        if(nullOrEmpty(String.valueOf(transaction.getConsumedProducts()))){
            notification.addError("Products is null or empty");
        }

        if(nullOrEmpty(String.valueOf(transaction.getTotalCost()))){
            notification.addError("Total cost is null or empty");
        }
        return notification;
    }
}
