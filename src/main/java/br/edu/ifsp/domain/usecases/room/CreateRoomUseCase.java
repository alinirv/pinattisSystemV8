package br.edu.ifsp.domain.usecases.room;

import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateRoomUseCase {
    private RoomDAO roomDAO;
    public CreateRoomUseCase(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }
    public Integer insert (Room room){
        Validator<Room> validator = new RoomInputRequestValidator();
        Notification notification = validator.validate(room);

        if(notification.hasErros())
            throw new IllegalArgumentException(notification.errorMessage());

        Integer roomNumber = room.getNumberRoom();
        if(roomDAO.findOneRoom(roomNumber).isPresent())
            throw new EntityAlreadyExistsException("Quarto já cadastrado.");

        return roomDAO.create(room);
    }
}
