package br.edu.ifsp.domain.usecases.cashier;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.cashier.Cashier;
import br.edu.ifsp.domain.usecases.booking.BookingDAO;
import br.edu.ifsp.domain.usecases.booking.BookingInputRequestValidator;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class OpenCashierUseCase {

    private CashierDAO cashierDAO;
    public OpenCashierUseCase(CashierDAO cashierDAO) {
        this.cashierDAO = cashierDAO;
    }
    public Integer open(Cashier cashier){
        Validator<Cashier> validator = new CashierInputRequestValidator();
        Notification notification = validator.validate(cashier);

        if(notification.hasErros())
            throw new IllegalArgumentException(notification.errorMessage());
        Integer id = cashier.getIdCashier();
        if(cashierDAO.findOne(id).isPresent())
            throw new EntityAlreadyExistsException("Caixa já existe.");

        return cashierDAO.create(cashier);

    }
}
