package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Cat;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class CatControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/cat";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";

    @Test
    public void addCat() {
        Cat cat = createCat();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getDescription());
    }

    @Test
    public void catDelete() {
        Cat cat = createCat();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getDescription());

        ResponseEntity<Cat> responseEntityForDeletedCat = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", responseEntityForDeletedCat.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedCat.getBody());

    }

    @Test
    public void getAllCats() {
        createCat();
        createCat();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Cat>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cat>>() {
                }
        );

        List<Cat> catList = responseEntity.getBody();
        assertNotNull(catList.get(0));
        assertNotNull(catList.get(1));

    }

    private Cat createCat() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCall("Murzik");

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Cat createdCat = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Cat.class
        ).getBody();

        assertNotNull(createdCat);
        assertEquals(cat.getName(), createdCat.getName());
        return createdCat;
    }

    @Test
    public void updateCat() {
        Cat cat = createCat();
        cat.setName("Snegok");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Cat.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getDescription());
        assertEquals("Snegok", receivedCat.getName());
    }

    private Cat prefillCall(String name) {
        Cat barsik = new Cat();
        barsik.setName(name);
        barsik.setDescription("Angry Cat");
        return barsik;
    }

}
