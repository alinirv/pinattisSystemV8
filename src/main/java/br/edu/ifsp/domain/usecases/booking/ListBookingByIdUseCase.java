package br.edu.ifsp.domain.usecases.booking;
import br.edu.ifsp.domain.entities.booking.Booking;

import java.util.List;

public class ListBookingByIdUseCase {
    private List<Booking> bookings;
    public ListBookingByIdUseCase(List<Booking> bookings){
        this.bookings = bookings;
    }

    public Booking getById(int idBooking) {
        for (Booking booking : bookings) {
            if (booking.getIdBooking() == idBooking) {
                return booking;
            }
        }
        return null;
    }
}
