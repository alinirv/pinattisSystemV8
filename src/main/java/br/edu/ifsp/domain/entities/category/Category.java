package br.edu.ifsp.domain.entities.category;

import br.edu.ifsp.domain.entities.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Integer idCategory;
    private String nameCategory;
    private List<Room> roomList;
    private CategoryPrice categoryPrice;
    private CategoryStatus categoryStatus;

    public Category() {
        categoryStatus = CategoryStatus.AVAILABLE;
    }

    public Category(Integer idCategory, String nameCategory, CategoryPrice categoryPrice, CategoryStatus categoryStatus) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.categoryPrice = categoryPrice;
        this.categoryStatus = categoryStatus;
    }

    public Category(Integer idCategory, String nameCategory, List<Room> rooms,
                    CategoryPrice categoryPrice, CategoryStatus categoryStatus) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.roomList = rooms;
        this.categoryPrice = categoryPrice;
        this.categoryStatus = categoryStatus;

        if (this.roomList == null) {
            this.roomList = new ArrayList<>();
        }
    }

    public Room selectRoom(int index) {
        return roomList.get(index);
    }

    public void addRoom(Room room) {
        if (this.roomList == null) {
            this.roomList = new ArrayList<>();
        }
        this.roomList.add(room);
    }

    public void removeRoom(Room room) {
        roomList.remove(room);
    }

    public List<Room> getRoom() {
        return roomList;
    }
    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public CategoryPrice getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(CategoryPrice categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    public CategoryStatus getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(CategoryStatus categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", nameCategory='" + nameCategory + '\'' +
                ", rooms=" + roomList +
                ", categoryPrice=" + categoryPrice +
                ", categoryStatus=" + categoryStatus +
                '}';
    }
}
