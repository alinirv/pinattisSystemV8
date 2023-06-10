package br.edu.ifsp.domain.usecases.booking;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.List;
import java.util.Optional;

public interface BookingDAO extends DAO<Booking, Integer> {
    boolean delete(Room type);

    List<Booking> findAllBooking();

    boolean updateBooking(Booking type);

    boolean disableRoom(Booking booking);

    Optional<Booking> findById(String id);

    Optional<Booking> findOneBooking(Integer id);
}
