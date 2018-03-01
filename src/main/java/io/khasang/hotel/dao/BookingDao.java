package io.khasang.hotel.dao;


import io.khasang.hotel.entity.Booking;

import java.util.List;

public interface BookingDao extends BasicDao<Booking>{
    List<Booking> getBookingByName(String name);
}
