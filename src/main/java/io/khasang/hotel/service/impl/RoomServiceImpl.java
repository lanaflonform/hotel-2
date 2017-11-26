package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.RoomDao;
import io.khasang.hotel.entity.Room;
import io.khasang.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoomService")
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Override
    public List<Room> getAllRooms() {
        return roomDao.getList();
    }

    @Override
    public Room getRoomById(long id) {
        return roomDao.getById(id);
    }

    @Override
    public Room addRoom(Room room) {
        return roomDao.add(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomDao.update(room);
    }

    @Override
    public Room getRoomByNum(int number) {
        return roomDao.getRoomByNum(number);
    }

    @Override
    public Room deleteRoom(long id) {
        return roomDao.delete(getRoomById(id));
    }
}
