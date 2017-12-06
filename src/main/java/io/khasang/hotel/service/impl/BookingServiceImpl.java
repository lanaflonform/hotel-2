package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.BookingDao;
import io.khasang.hotel.entity.Booking;
import io.khasang.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookingService")
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingDao bookingDao;

    @Override
    public List<Booking> getAllBookings() {
        return bookingDao.getList();
    }

    @Override
    public Booking getBookingById(long id) {
        return bookingDao.getById(id);
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingDao.add(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingDao.update(booking);
    }

    @Override
    public List<Booking> getBookingsByName(String name) {
        return bookingDao.getBookingByName(name);
    }

    @Override
    public Booking deleteBooking(long id) {
        return bookingDao.delete(getBookingById(id));
    }
}
