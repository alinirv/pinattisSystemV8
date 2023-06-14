package br.edu.ifsp.domain.entities.category;

import br.edu.ifsp.domain.entities.room.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
    private Integer idCategory;
    private String nameCategory;
    private List<Room> roomList;
    private CategoryStatus categoryStatus;
    private CategoryPrice price;
    private Map<CategoryPrice, Double> prices = new HashMap<>();

    public Category() {
        categoryStatus = CategoryStatus.AVAILABLE;
    }

    public Category(String nameCategory, List<Room> roomList) {
        this.nameCategory = nameCategory;
        this.roomList = roomList;
        this.categoryStatus =CategoryStatus.AVAILABLE;
    }

    public Category(Integer idCategory, String nameCategory, CategoryStatus categoryStatus) {
        this(null, nameCategory, null, categoryStatus);
    }


    public Category(Integer idCategory, String nameCategory, List<Room> rooms, CategoryStatus categoryStatus) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.roomList = rooms;
        this.categoryStatus = categoryStatus;

        if (this.roomList == null) {
            this.roomList = new ArrayList<>();
        }
    }

    public  void setCategoryPrice(CategoryPrice category, Double price){
        prices.put(category, price);

    }

    public Double getPriceBy(CategoryPrice category){
        return prices.get(category);
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

    public CategoryPrice getPrice() {
        return price;
    }

    public void setPrice(CategoryPrice price) {
        this.price = price;
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
                ", categoryStatus=" + categoryStatus +
                '}';
    }
}
