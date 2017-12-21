package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.BookingDao;
import io.khasang.hotel.dto.BookingDTO;
import io.khasang.hotel.entity.Booking;
import io.khasang.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("BookingService")
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private BookingDTO bookingDTO;

    @Override
    public Set<BookingDTO> getAllBookings() {
        return bookingDTO.getSetDTO(bookingDao.getSet());
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
    public Set<BookingDTO> getBookingsByName(String name) {
        return bookingDTO.getSetDTOFromList(bookingDao.getBookingByName(name));
    }

    @Override
    public Booking deleteBooking(long id) {
        return bookingDao.delete(getBookingById(id));
    }
}
