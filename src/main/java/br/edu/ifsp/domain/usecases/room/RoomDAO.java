package br.edu.ifsp.domain.usecases.room;

import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.List;
import java.util.Optional;

public interface RoomDAO extends  DAO<Room, Integer>{
    Optional<Room> findOneRoom(Integer key);

    List<Room> findAllRooms();


    boolean disableRoom(Room room);
}

