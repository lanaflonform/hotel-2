package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.BookingDao;
import io.khasang.hotel.entity.Booking;

import java.util.List;

public class BookingDaoImpl extends BasicDaoImpl<Booking> implements BookingDao {

    public BookingDaoImpl(Class<Booking> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Booking> getBookingByName(String name) {
        return (List<Booking>) sessionFactory.getCurrentSession().
                createQuery("from Booking as b where b.name = ?").setParameter(0, name).list();
    }
}
