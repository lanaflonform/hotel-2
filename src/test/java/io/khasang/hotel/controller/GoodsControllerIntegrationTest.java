package io.khasang.hotel.controller;

import io.khasang.hotel.dto.goodsdto.GoodsFactoryForTests;
import io.khasang.hotel.entity.goods.Goods;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GoodsControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/goods";
    private final String ALL = "/all";
    private final String ADD = "/add";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";


    @Test
    public void getAllGoods() {
        addGoodsResponseEntity();
        addGoodsResponseEntity();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Goods>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Goods>>() {
                }
        );

        List<Goods> goodsDTOSet = responseEntity.getBody();
        assertNotNull(goodsDTOSet);
        assertNotNull(goodsDTOSet.iterator().next().getName());
    }

    @Test
    public void deleteGoods() {
        Goods goods = addGoodsResponseEntity().getBody();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Goods> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Goods.class,
                goods.getId()
        );
        int i = 0;
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Goods receivedGoods = responseEntity.getBody();
        assertNotNull(receivedGoods.getName());

        ResponseEntity<Goods> responseEntityForDeleteGoods = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Goods.class,
                receivedGoods.getId()
        );
        assertEquals("OK", responseEntityForDeleteGoods.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeleteGoods.getBody());
    }

    @Test
    public void updateGoods() {
        Goods goods = addGoodsResponseEntity().getBody();
        goods.setStock(10);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Goods> httpEntity = new HttpEntity<>(goods, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Goods> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Goods.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Goods receivedGoods = responseEntity.getBody();
        assertNotNull(receivedGoods.getName());
        assertEquals(10, receivedGoods.getStock());
    }

    @Test
    public void addGoods() {
        ResponseEntity<Goods> createdGoodsResponseEntity = addGoodsResponseEntity();

        assertNotNull(createdGoodsResponseEntity.getBody());
        assertEquals("OK", createdGoodsResponseEntity.getStatusCode().getReasonPhrase());
    }

    @Test
    public void getById() {
        // create and add entity in database
        ResponseEntity<Goods> createdGoodsResponseEntity = addGoodsResponseEntity();

        // check if entity in DB
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Goods> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Goods.class,
                createdGoodsResponseEntity.getBody().getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNotNull(responseEntity.getBody().getName());
    }

    @Test
    public void getNonexistentEntityById() {
        // check if entity in DB
        long nonexistentID = 999999999999999999L;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Goods> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Goods.class,
                nonexistentID
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNull(responseEntity.getBody());
    }

    private ResponseEntity<Goods> addGoodsResponseEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Goods goods = (new GoodsFactoryForTests()).getTestGoods();
        HttpEntity<Goods> httpEntity = new HttpEntity<>(goods, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Goods.class
        );
    }
}
