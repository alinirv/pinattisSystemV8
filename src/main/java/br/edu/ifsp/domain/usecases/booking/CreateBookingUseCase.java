package br.edu.ifsp.domain.usecases.booking;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateBookingUseCase {
    private BookingDAO bookingDAO;
    public CreateBookingUseCase(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }
    public Integer insert (Booking booking){
        Validator<Booking> validator = new BookingInputRequestValidator();
        Notification notification = validator.validate(booking);

        if(notification.hasErros())
            throw new IllegalArgumentException(notification.errorMessage());

        System.out.println("Booking forwarded\n");
        return bookingDAO.create(booking);
    }
}
