package br.edu.ifsp.domain.entities.booking;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.room.Room;

import java.time.LocalDateTime;

public class Booking {
    private  Integer idBooking;
    private Room room;
    private String nameCategory;

    private Double price;
    private LocalDateTime startDateBooking;
    private LocalDateTime finishDateBooking;

    // traser classe transactio para esta classe


    private boolean finished;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Booking() {
    }

    public Booking(Room room, Category category, String nameCategory, Double price, LocalDateTime startDateBooking,
                   LocalDateTime finishDateBooking, boolean finished) {
        this.room = category.selectRoom(0);
        this.nameCategory = category.getNameCategory();
        this.price = price;
        this.startDateBooking = startDateBooking;
        this.finishDateBooking = finishDateBooking;
        this.finished = finished;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Booking(Integer idBooking, Room room, String nameCategory, Double price, LocalDateTime startDateBooking,
                   LocalDateTime finishDateBooking, boolean finished) {
        this.idBooking = idBooking;
        this.room = room;
        this.nameCategory = nameCategory;
        this.price = price;
        this.startDateBooking = startDateBooking;
        this.finishDateBooking = finishDateBooking;
        this.finished = finished;
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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void toFinish() {
        this.finished = true;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", room=" + room.getNumberRoom() +
                ", nameCategory='" + nameCategory + '\'' +
                ", startDateBooking=" + startDateBooking +
                ", finishDateBooking=" + finishDateBooking +
                ", finish=" + finished +
                '}';
    }
}
