package br.edu.ifsp.domain.usecases.room;


import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class DisableRoomUseCase {
    private RoomDAO roomDAO;

    public DisableRoomUseCase(RoomDAO roomDAO){
        this.roomDAO = roomDAO;
    }

    public boolean disableRoom(Integer id){
        if (id == null || roomDAO.findOne(id).isEmpty()){
            throw new EntityNotFoundException("Room not found");
        }
        return roomDAO.deleteByKey(id);
    }

    public boolean disableRoom(Room room){
        if (room == null || roomDAO.findOne(room.getIdRoom()).isEmpty()){
            throw new EntityNotFoundException("Room not found");
        }
        return roomDAO.disableRoom(room);
    }
}
