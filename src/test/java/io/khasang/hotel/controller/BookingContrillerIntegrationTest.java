package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Booking;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BookingContrillerIntegrationTest {
    private final String ROOT = "http://localhost:8080/booking";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";

    @Test
    public void addBooking() {
        Booking booking = createBooking();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Booking> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Booking.class,
                booking.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Booking receivedBooking = responseEntity.getBody();
        assertNotNull(receivedBooking.getRoom());
    }

    @Test
    public void bookingDelete() {
        Booking booking = createBooking();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Booking> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Booking.class,
                booking.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Booking receivedBooking = responseEntity.getBody();
        assertNotNull(receivedBooking.getRoom());

        ResponseEntity<Booking> responseEntityForDeletedBooking = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Booking.class,
                booking.getId()
        );

        assertEquals("OK", responseEntityForDeletedBooking.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedBooking.getBody());

    }

    @Test
    public void getAllBookings() {
        createBooking();
        createBooking();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Booking>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Booking>>() {
                }
        );

        List<Booking> bookingList = responseEntity.getBody();
        assertNotNull(bookingList.get(0));
        assertNotNull(bookingList.get(1));

    }

    private Booking createBooking() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Booking booking = prefillCall("Petrov");

        HttpEntity<Booking> httpEntity = new HttpEntity<>(booking, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Booking createdBooking = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Booking.class
        ).getBody();

        assertNotNull(createdBooking);
        assertEquals(booking.getName(), createdBooking.getName());
        return createdBooking;
    }

    @Test
    public void updateBooking() {
        Booking booking = createBooking();
        booking.setName("Petrov");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Booking> httpEntity = new HttpEntity<>(booking, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Booking> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Booking.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Booking receivedBooking = responseEntity.getBody();
        assertNotNull(receivedBooking.getRoom());
        assertEquals("Petrov", receivedBooking.getName());
    }

    private Booking prefillCall(String name) {
        Booking petrov = new Booking();
        petrov.setName(name);
        petrov.setRoom("402");
        petrov.setStartDate(new Date());
        petrov.setEndDate(new Date());
        return petrov;
    }
}
