package io.khasang.hotel.service;

import io.khasang.hotel.dto.RoomDTO;
import io.khasang.hotel.entity.Room;

import java.util.Set;

public interface RoomService {
    Room addRoom(Room room);
    Set<RoomDTO> getSet();
}
