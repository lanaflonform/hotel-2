package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.RoomDao;
import io.khasang.hotel.entity.Room;

public class RoomDaoImpl extends BasicDaoImpl<Room> implements RoomDao {
    public RoomDaoImpl(Class<Room> entityClass) {
        super(entityClass);
    }
}