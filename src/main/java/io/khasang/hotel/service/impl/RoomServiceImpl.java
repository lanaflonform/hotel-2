package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.RoomDao;
import io.khasang.hotel.dto.RoomDTO;
import io.khasang.hotel.entity.Room;
import io.khasang.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("roomService")
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Autowired
    private RoomDTO roomDTO;

    @Override
    public Room addRoom(Room room) {
        return roomDao.add(room);
    }

    @Override
    public Set<RoomDTO> getSet() {
        return roomDTO.getRoomDTO(roomDao.getSet());
    }
}
