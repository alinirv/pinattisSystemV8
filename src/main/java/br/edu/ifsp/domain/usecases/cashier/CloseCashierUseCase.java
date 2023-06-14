package br.edu.ifsp.domain.usecases.cashier;

import br.edu.ifsp.domain.entities.cashier.Cashier;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CloseCashierUseCase {
    private CashierDAO cashierDAO;
    public CloseCashierUseCase(CashierDAO cashierDAO) {
        this.cashierDAO = cashierDAO;
    }

    public Boolean Close(Cashier cashier){

        Validator<Cashier> validator = new CashierInputRequestValidator();
        Notification notification = validator.validate(cashier);

        if(notification.hasErros())
            throw new IllegalArgumentException(notification.errorMessage());

        return cashierDAO.update(cashier);

    }

}
