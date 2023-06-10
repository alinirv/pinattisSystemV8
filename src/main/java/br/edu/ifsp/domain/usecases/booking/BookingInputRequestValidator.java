package br.edu.ifsp.domain.usecases.booking;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class BookingInputRequestValidator extends Validator<Booking> {
    @Override
    public Notification validate(Booking booking) {
        Notification notification = new Notification();
        if (booking == null) {
            notification.addError("Booking is null");
            return notification;
        }

        if(nullOrEmpty(String.valueOf(booking.getNameCategory()))){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(String.valueOf(booking.getStartDateBooking()))){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(String.valueOf(booking.getFinishDateBooking()))){
            notification.addError("Name is null or empty");
        }

        return notification;
    }
}
