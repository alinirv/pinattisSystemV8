package br.edu.ifsp.domain.usecases.booking;

import br.edu.ifsp.domain.entities.booking.Booking;

import java.util.List;
import java.util.Optional;

public class ListBookingUseCase {
    private BookingDAO bookingDAO;

    public ListBookingUseCase(BookingDAO bookingDAO){
        this.bookingDAO = bookingDAO;
    }

    public Optional<Booking> findOneBooking(Integer id){
        if (id == null){
            throw new IllegalArgumentException("ID can not be found");
        }
        return bookingDAO.findOneBooking(id);
    }

    public List<Booking> findAllBooking(Booking booking1){
        return bookingDAO.findAll();
    }
}
