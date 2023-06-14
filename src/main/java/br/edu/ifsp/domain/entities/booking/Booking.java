package br.edu.ifsp.domain.entities.booking;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.room.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private Integer idBooking;
    private Integer numberRoom;
    private String nameCategory;
    private String service;
    private LocalDateTime startDateBooking;
    private LocalDateTime finishDateBooking;
    private BookingStatus bookingStatus;


    public Booking() {
    }

    public Booking(Integer numberRoom, String nameCategory, String service, LocalDateTime startDateBooking, LocalDateTime finishDateBooking, BookingStatus bookingStatus) {
        this(null,numberRoom, nameCategory,service,startDateBooking,finishDateBooking, bookingStatus);
    }

    public Booking(Integer idBooking, Integer numberRoom, String nameCategory, String service, LocalDateTime startDateBooking, LocalDateTime finishDateBooking, BookingStatus bookingStatus) {
        this.idBooking = idBooking;
        this.numberRoom = numberRoom;
        this.nameCategory = nameCategory;
        this.service = service;
        this.startDateBooking = startDateBooking;
        this.finishDateBooking = finishDateBooking;
        this.bookingStatus = bookingStatus;
    }

    public Boolean isFinished(Booking booking){
        if (booking.getBookingStatus() == BookingStatus.FINISHED)
            return true;
        return false;
    }
    public void toFinish(Booking booking) {
        booking.setBookingStatus(BookingStatus.FINISHED);
    }
    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Integer getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LocalDateTime getStartDateBooking() {
        return startDateBooking;
    }

    public void setStartDateBooking(LocalDateTime startDateBooking) {
        this.startDateBooking = startDateBooking;
    }

    public LocalDateTime getFinishDateBooking() {
        return finishDateBooking;
    }

    public void setFinishDateBooking(LocalDateTime finishDateBooking) {
        this.finishDateBooking = finishDateBooking;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", numberRoom=" + numberRoom +
                ", nameCategory='" + nameCategory + '\'' +
                ", service='" + service + '\'' +
                ", startDateBooking=" + startDateBooking +
                ", finishDateBooking=" + finishDateBooking +
                ", bookingStatus=" + bookingStatus +
                '}';
    }


}
