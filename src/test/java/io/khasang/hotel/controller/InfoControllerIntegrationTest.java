package io.khasang.hotel.controller;

import io.khasang.hotel.dto.InfoDTO;
import io.khasang.hotel.entity.Info;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

import static org.junit.Assert.*;

public class InfoControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/info";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";

    @Test
    public void addInfo() {
        Info info = createInfo();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Info> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Info.class,
                info.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Info receivedInfo = responseEntity.getBody();
        assertNotNull(receivedInfo.getAddress());
    }



    @Test
    public void getAllInfos() {
        createInfo();
        createInfo();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Set<InfoDTO>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<InfoDTO>>() {
                }
        );

        Set<InfoDTO> infoSet = responseEntity.getBody();
        assertNotNull(infoSet);
    }

    private Info createInfo() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Info info = prefillCall("Sun Palas");

        HttpEntity<Info> httpEntity = new HttpEntity<>(info, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Info createdInfo = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Info.class
        ).getBody();

        assertNotNull(createdInfo);
        assertEquals(info.getHotelName(), createdInfo.getHotelName());
        return createdInfo;
    }

    @Test
    public void updateInfo() {
        Info info = createInfo();
        info.setHotelName("Sun Palas");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Info> httpEntity = new HttpEntity<>(info, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Info> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Info.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Info receivedInfo = responseEntity.getBody();
        assertNotNull(receivedInfo.getAddress());
        assertEquals("Sun Palas", receivedInfo.getHotelName());
    }

    @Test
    public void infoDelete() {
        Info info = createInfo();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Info> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Info.class,
                info.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Info receivedInfo = responseEntity.getBody();
        assertNotNull(receivedInfo.getAddress());

        ResponseEntity<Info> responseEntityForDeletedInfo = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Info.class,
                info.getId()
        );

        assertEquals("OK", responseEntityForDeletedInfo.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedInfo.getBody());

    }

    private Info prefillCall(String name) {
        Info info = new Info();
        info.setHotelName(name);
        info.setAddress("s.Any str.Moon 54");
        info.setNumberOfRooms(200);
        return info;
    }
}
