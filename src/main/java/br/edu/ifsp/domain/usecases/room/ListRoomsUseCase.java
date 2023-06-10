package br.edu.ifsp.domain.usecases.room;

import br.edu.ifsp.domain.entities.room.Room;

import java.util.List;
import java.util.Optional;

public class ListRoomsUseCase {
    private RoomDAO roomDAO;

    public ListRoomsUseCase(RoomDAO roomDAO){
        this.roomDAO = roomDAO;
    }

    public Optional<Room> findOneRoom(Integer id){
        if (id == null){
            throw new IllegalArgumentException("ID can not be found");
        }
        return roomDAO.findOneRoom(id);
    }

    public List<Room> findAllRooms(){
        return roomDAO.findAll();
    }
}
