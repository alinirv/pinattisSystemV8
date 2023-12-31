package br.edu.ifsp.domain.usecases.booking;

import br.edu.ifsp.domain.entities.booking.Booking;
import br.edu.ifsp.domain.entities.room.Room;

import java.util.Optional;

import static br.edu.ifsp.application.main.Main.findRoomUseCase;
import static br.edu.ifsp.application.main.Main.updateRoomUseCase;

public class FinishBookingUseCase {
    private BookingDAO bookingDAO;
    public FinishBookingUseCase(BookingDAO listBookingByIdUseCase){
        bookingDAO = listBookingByIdUseCase;
    }
    public  void finishBooking(int idBooking){
        Booking booking = bookingDAO.findOneBooking(idBooking).get();
        if (booking != null) {
            if (!booking.isFinished(booking)) {
                booking.toFinish(booking);
                Optional<Room> room = findRoomUseCase.findOneRoom(booking.getNumberRoom());
                room.get().turnedRoomAvailable();
                updateRoomUseCase.update(room.get());
                System.out.println("Booking ID " + booking.getIdBooking()+ " sucess finished.");
            } else {
                System.out.println("The booking with ID " + booking.getIdBooking() + " already finished.");
            }
        } else {
            System.out.println("There is not booking with ID " + booking.getIdBooking() + " or is it already finished.");
        }
    }
}
