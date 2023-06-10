package br.edu.ifsp.domain.entities.booking;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.room.Room;

import java.time.LocalDate;

public class Booking {
    private Integer idBooking;
    private Room room;
    private String nameCategory;
    private LocalDate startDateBooking;
    private LocalDate finishDateBooking;
    private boolean finish;

    public Booking() {
    }

    public Booking(Room room, Category category, String nameCategory, LocalDate startDateBooking,
                   LocalDate finishDateBooking, boolean finish) {
        this.room = category.selectRoom(0);
        this.nameCategory = category.getNameCategory();
        this.startDateBooking = startDateBooking;
        this.finishDateBooking = finishDateBooking;
        this.finish = finish;
    }

    public Booking(Integer idBooking, Room room, String nameCategory, LocalDate startDateBooking,
                   LocalDate finishDateBooking, boolean finish) {
        this.idBooking = idBooking;
        this.room = room;
        this.nameCategory = nameCategory;
        this.startDateBooking = startDateBooking;
        this.finishDateBooking = finishDateBooking;
        this.finish = finish;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public LocalDate getStartDateBooking() {
        return startDateBooking;
    }

    public void setStartDateBooking(LocalDate startDateBooking) {
        this.startDateBooking = startDateBooking;
    }

    public LocalDate getFinishDateBooking() {
        return finishDateBooking;
    }

    public void setFinishDateBooking(LocalDate finishDateBooking) {
        this.finishDateBooking = finishDateBooking;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void toFinish() {
        this.finish = true;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", room=" + room.getNumberRoom() +
                ", nameCategory='" + nameCategory + '\'' +
                ", startDateBooking=" + startDateBooking +
                ", finishDateBooking=" + finishDateBooking +
                ", finish=" + finish +
                '}';
    }
}
