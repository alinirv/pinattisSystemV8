package br.edu.ifsp.domain.usecases.cashier;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.cashier.Cashier;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CashierInputRequestValidator extends Validator<Cashier> {
    @Override
    public Notification validate(Cashier cashier) {

        Notification notification = new Notification();
        if (cashier == null) {
            notification.addError("Caixa invalido");
            return notification;
        }
        if(nullOrEmpty(String.valueOf(cashier.getUser()))){
            notification.addError("Usuario invalido");
        }
        if(nullOrEmpty(String.valueOf(cashier.getOpeningBalance()))){
            notification.addError("Valor invalido");
        }
        return notification;
    }
}
