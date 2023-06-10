package br.edu.ifsp.application.repository;

import br.edu.ifsp.domain.entities.room.Room;
import br.edu.ifsp.domain.usecases.room.RoomDAO;

import java.util.*;

public class InMemoryRoomDAO implements RoomDAO {

    private static final Map<Integer, Room> db = new LinkedHashMap<>();
    private static int idCounter;

    @Override
    public Integer create(Room room) {
        idCounter++;
        room.setIdRoom(idCounter);
        db.put(idCounter, room);
        return idCounter;
    }

    @Override
    public Optional<Room> findOne(Integer key) {
        return Optional.empty();
    }

    @Override
    public Optional<Room> findOneRoom(Integer key) {
        if (db.containsKey(key)){
            return Optional.of(db.get(key));
        }
        return Optional.empty();
    }

    @Override
    public List<Room> findAllRooms() {

        //return null;
        return  new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Room room) {
        Integer id = room.getIdRoom();
        if (db.containsKey(id)){
            db.replace(id, room);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        if (db.containsKey(key)){
            db.remove(key);
        }
        return false;
    }

    @Override
    public boolean delete(Room type) {
        return false;
    }

    @Override
    public boolean disableRoom(Room room) {

        return deleteByKey(room.getIdRoom());
    }

    @Override
    public List<Room> findAll() {
        return new ArrayList<>(db.values());
    }

}
