package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.booking.BookingDAO;

import java.util.*;

public class InMemoryBookingDAO implements BookingDAO {
    private static final Map<Integer, Booking> db = new LinkedHashMap<>();
    private static int idCounter;

    @Override
    public Integer create(Booking booking) {
        idCounter++;
        booking.setIdBooking(idCounter);
        db.put(idCounter, booking);
        return idCounter;
    }

    @Override
    public Optional<Booking> findOneBooking(Integer key) {
        if (db.containsKey(key)){
            return Optional.of(db.get(key));
        }
        return Optional.empty();
    }

    @Override
    public List<Booking> findAllBooking() {
        return  new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Booking booking) {
        Integer id = booking.getIdBooking();
        if (db.containsKey(id)){
            db.replace(id, booking);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Booking> findOne(Integer key) {
        return Optional.empty();
    }

    @Override
    public List<Booking> findAll() {
        return null;
    }

    @Override
    public boolean updateBooking(Booking type) {
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        if (db.containsKey(key)){
            db.remove(key);
        }
        return false;
    }

    @Override
    public boolean delete(Booking type) {
        return false;
    }

    @Override
    public boolean disableRoom(Booking booking) {

        return deleteByKey(booking.getIdBooking());
    }

    @Override
    public Optional<Booking> findById(String id) {
        return Optional.empty();
    }



    @Override
    public boolean delete(Room type) {
        return false;
    }
}
