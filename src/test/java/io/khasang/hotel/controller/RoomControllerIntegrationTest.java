package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Room;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class RoomControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/room";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";

    @Test
    public void addRoom() {
        Room room = createRoom();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Room> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Room.class,
                room.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Room recivedRoom = responseEntity.getBody();
        assertNotNull(recivedRoom.getDescription());
    }

    @Test
    public void roomDelete() {
        Room room = createRoom();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Room> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Room.class,
                room.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Room receivedRoom = responseEntity.getBody();
        assertNotNull(receivedRoom.getDescription());

        ResponseEntity<Room> responseEntityForDeletedRoom = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Room.class,
                room.getId()
        );

        assertEquals("OK", responseEntityForDeletedRoom.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedRoom.getBody());

    }

    @Test
    public void getAllRooms() {
        createRoom();
        createRoom();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Room>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Room>>() {
                }
        );

        List<Room> roomList = responseEntity.getBody();
        assertNotNull(roomList.get(0));
        assertNotNull(roomList.get(1));

    }

    private Room createRoom() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Room room = prefillCall(999, "TestDescription", "TestType");
        HttpEntity<Room> httpEntity = new HttpEntity<>(room, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Room createdRoom = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Room.class
        ).getBody();

        assertNotNull(createdRoom);
        assertEquals(room.getDescription(),createdRoom.getDescription());
        assertEquals(room.getNumber(),createdRoom.getNumber());
        assertEquals(room.getType(),createdRoom.getType());
        return createdRoom;
    }

    @Test
    public void updateRoom() {
        Room room = createRoom();
        room.setType("updatedTestType");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Room> httpEntity = new HttpEntity<>(room, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Room> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Room.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Room receivedRoom = responseEntity.getBody();
        assertNotNull(receivedRoom.getDescription());
        assertEquals("updatedTestType", receivedRoom.getType());
    }

    private Room prefillCall(int testNumber, String testDescription, String testType) {
        Room testRoom = new Room();
        testRoom.setNumber(testNumber);
        testRoom.setDescription(testDescription);
        testRoom.setType(testType);
        return testRoom;
    }
}
