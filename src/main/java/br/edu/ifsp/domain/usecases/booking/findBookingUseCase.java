package br.edu.ifsp.domain.usecases.booking;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class findBookingUseCase {
    private BookingDAO bookingDAO;

    public findBookingUseCase(BookingDAO bookingDAO){
        this.bookingDAO = bookingDAO;
    }

    public Optional<Booking> findOneBooking(Integer room) {
        if (Validator.nullOrEmpty(Collections.singleton(room)))
            throw new IllegalArgumentException("Por favor, preencha um numero de quarto valido. ");
        return bookingDAO.findOneBooking(room);
    }

    public List<Booking> findAll(){
        return bookingDAO.findAll();
    }
}
