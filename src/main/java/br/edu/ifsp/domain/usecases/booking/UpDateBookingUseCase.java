package br.edu.ifsp.domain.usecases.booking;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpDateBookingUseCase {
    private BookingDAO bookingDAO;

    public UpDateBookingUseCase(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public Boolean updateBooking(Booking booking) {
        Validator<Booking> validator = new BookingInputRequestValidator();
        Notification notification = validator.validate(booking);

        if (notification.hasErros()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }

        Integer id = booking.getIdBooking();
        if (bookingDAO.findOne(id).isEmpty()) {
            throw new EntityNotFoundException("Product not found");
        }

        return bookingDAO.update(booking);
    }
}
