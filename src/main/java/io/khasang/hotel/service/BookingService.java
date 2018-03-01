package io.khasang.hotel.service;

import io.khasang.hotel.dto.BookingDTO;
import io.khasang.hotel.entity.Booking;

import java.util.Set;

public interface BookingService {
    /**
     * method for receiving all Bookings
     *
     * @return all bookings
     */
    Set<BookingDTO> getAllBookings();

    /**
     * @param id - booking id
     * @return Booking by id
     */
    Booking getBookingById(long id);

    /**
     * @param booking - booking that should be added to DB
     * @return booking
     */
    Booking addBooking(Booking booking);


    /**
     * @param booking - booking that should be updated to DB
     * @return booking
     */
    Booking updateBooking(Booking booking);

    /**
     * @param name - name of bookings
     * @return list of bookings with specify name
     */
    Set<BookingDTO> getBookingsByName(String name);

    /**
     * @param id - booking id for remove
     * @return  deleted booking
     * */
    Booking deleteBooking(long id);
}
