package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.RoomDao;
import io.khasang.hotel.entity.Room;

public class RoomDaoImpl  extends BasicDaoImpl<Room> implements RoomDao {

    public RoomDaoImpl(Class<Room> entityClass) {
        super(entityClass);
    }

    @Override
    public Room getRoomByNum(int number) {
        return (Room) sessionFactory.getCurrentSession().
                createQuery("from Room as r where r.number = ?").setParameter(0, number);
    }
}
