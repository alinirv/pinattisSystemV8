package br.edu.ifsp.domain.entities.room;

public class Room {
    private Integer idRoom;
    private Integer numberRoom;
    private RoomStatus roomStatus;

    public Room() {
        roomStatus = RoomStatus.AVAILABLE;
    }

    public Room(Integer numberRoom, RoomStatus roomStatus) {
        this(null, numberRoom, roomStatus);
    }

    public Room(Integer idRoom, Integer numberRoom, RoomStatus roomStatus) {
        this.idRoom = idRoom;
        this.numberRoom = numberRoom;
        this.roomStatus = roomStatus;
    }

    public void turnedRoomOccupied (){
        if (getRoomStatus() == RoomStatus.INACTIVE) {
            throw new IllegalArgumentException("The room is inactive.");
        }

        if (getRoomStatus() == RoomStatus.OCCUPIED) {
            throw new IllegalArgumentException("The room is occupied.");
        }

        setRoomStatus(RoomStatus.OCCUPIED);
        System.out.println("The room has been successfully booked.");
    }

    public void turnedRoomAvailable() {
        if (getRoomStatus() == RoomStatus.AVAILABLE)
            throw new IllegalArgumentException("The room is already released.");

        if (getRoomStatus() == RoomStatus.INACTIVE)
            throw new IllegalArgumentException("The room is inactive.");

        setRoomStatus(RoomStatus.AVAILABLE);
        System.out.println("The room successfully released.");
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + idRoom +
                ", number=" + numberRoom +
                ", status=" + roomStatus + '\'' +
                '}';
    }
}
