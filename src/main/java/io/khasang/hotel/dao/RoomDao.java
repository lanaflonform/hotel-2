package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Room;

public interface RoomDao extends BasicDao<Room> {
    Room getRoomByNum(int number); 
}
