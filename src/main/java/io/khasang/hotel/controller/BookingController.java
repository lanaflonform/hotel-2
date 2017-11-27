package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Booking;
import io.khasang.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Booking> getAllBooking() {
        return bookingService.getAllBookings();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Booking getBookingById(@PathVariable(value = "id") String id) {
        return bookingService.getBookingById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @ResponseBody
    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    public List<Booking> getBookingByName(@PathVariable("name") String name) {
        return bookingService.getBookingsByName(name);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Booking deleteBooking(@RequestParam(value = "id") String id) {
        return bookingService.deleteBooking(Long.parseLong(id));
    }
}
