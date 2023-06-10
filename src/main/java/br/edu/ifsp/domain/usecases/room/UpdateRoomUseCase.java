package br.edu.ifsp.domain.usecases.room;

import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateRoomUseCase {
    private RoomDAO roomDAO;

    public UpdateRoomUseCase(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Boolean update(Room room){
        Validator<Room> validator = new RoomInputRequestValidator();
        Notification notification = validator.validate(room);

        if (notification.hasErros()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        Integer id = room.getIdRoom();
        if (roomDAO.findOne(id).isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }

        return roomDAO.update(room);
    }
}
