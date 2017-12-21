package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Booking;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BookingDTO {
    private long id;
    private String name;
    private String room;
    private LocalDate startDate;
    private LocalDate endDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<BookingDTO> getSetDTO(Set<Booking> getSetBooking) {
        Set<BookingDTO> bookingDTOSet = new HashSet<>();

        for (Booking booking: getSetBooking) {
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setId(booking.getId());
            bookingDTO.setName(booking.getName());
            bookingDTO.setRoom(booking.getRoom());
            bookingDTO.setStartDate(booking.getStartDate());
            bookingDTO.setEndDate(booking.getEndDate());
            bookingDTOSet.add(bookingDTO);
        }
        return bookingDTOSet;
    }

    public Set<BookingDTO> getSetDTOFromList(List<Booking> bookingByName) {
        Set<BookingDTO> bookingDTOSet = new HashSet<>();

        for (Booking booking: bookingByName) {
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setId(booking.getId());
            bookingDTO.setRoom(booking.getRoom());
            bookingDTO.setName(booking.getName());
            bookingDTO.setStartDate(booking.getStartDate());
            bookingDTO.setEndDate(booking.getEndDate());
            bookingDTOSet.add(bookingDTO);
        }
        return bookingDTOSet;
    }
}
