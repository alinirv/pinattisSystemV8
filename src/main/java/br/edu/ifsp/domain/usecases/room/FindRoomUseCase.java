package br.edu.ifsp.domain.usecases.room;

import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.List;
import java.util.Optional;

public class FindRoomUseCase {
    private RoomDAO roomDAO;

    public FindRoomUseCase(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Optional<Room> findOneRoom(Integer roomNumber) {
        if (Validator.nullOrEmpty(String.valueOf(roomNumber)))
            throw new IllegalArgumentException("Digite um número válido.");
        return roomDAO.findOneRoom(roomNumber);
    }

    public List<Room> findAll() {
        return roomDAO.findAll();
    }


}
