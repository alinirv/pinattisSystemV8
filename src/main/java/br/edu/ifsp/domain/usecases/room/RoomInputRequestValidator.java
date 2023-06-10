package br.edu.ifsp.domain.usecases.room;

import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class RoomInputRequestValidator extends Validator<Room> {
    @Override
    public Notification validate(Room room) {
        Notification notification = new Notification();
        if (room == null) {
            notification.addError("Room is null");
            return notification;
        }

        if(nullOrEmpty(room.getIdRoom().toString())){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(room.getNumberRoom().toString())){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(room.getRoomStatus().toString())){
            notification.addError("Name is null or empty");
        }

        return notification;
    }

}
