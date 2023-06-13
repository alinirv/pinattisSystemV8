package br.edu.ifsp.domain.entities.booking;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.entities.category.CategoryPrice;
import br.edu.ifsp.domain.entities.room.Room;

import java.time.LocalDateTime;

public class BookingN {
    private Integer idBooking;
    private Room room;
    private String nameCategory;
    private CategoryPrice service;
    private LocalDateTime startDateBooking;
    private LocalDateTime finishDateBooking;
    private BookingStatus status;

    private Category category;

    public BookingN() {
    }

    public BookingN(Integer idBooking, Room room, Category service, LocalDateTime startDateBooking, LocalDateTime finishDateBooking, BookingStatus status) {
        this.idBooking = idBooking;
        this.room = category.selectRoom(0);
        this.nameCategory = category.getNameCategory();
        this.startDateBooking = startDateBooking;
        this.finishDateBooking = finishDateBooking;
        this.status = status;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public CategoryPrice getService() {
        return service;
    }

    public void setService(CategoryPrice service) {
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

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
