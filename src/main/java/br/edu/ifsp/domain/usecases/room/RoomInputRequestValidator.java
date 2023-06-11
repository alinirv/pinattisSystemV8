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

        if(nullOrEmpty(String.valueOf(room.getIdRoom()))){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(String.valueOf(room.getNumberRoom()))){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(String.valueOf(room.getRoomStatus()))){
            notification.addError("Name is null or empty");
        }

        return notification;
    }

}
