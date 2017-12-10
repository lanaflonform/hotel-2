package io.khasang.hotel.controller;

import io.khasang.hotel.entity.goods.Goods;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class GoodsControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/goods";
    private final String ALL = "/all";
    private final String ADD = "/add";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";


    @Test
    public void addGoods() {
        Goods goods = createGoods();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Goods> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Goods.class,
                goods.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Goods receivedGoods = responseEntity.getBody();
        assertNotNull(receivedGoods.getName());
    }

    @Test
    public void getAllGoods() {
        createGoods();
        createGoods();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Goods>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Goods>>() {
                }
        );

        List<Goods> goodsList = responseEntity.getBody();
        assertNotNull(goodsList.get(0));
        assertNotNull(goodsList.get(1));
    }

    @Test
    public void deleteGoods() {
        Goods goods = createGoods();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Goods> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Goods.class,
                goods.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Goods receivedGoods = responseEntity.getBody();
        assertNotNull(receivedGoods.getName());

        ResponseEntity<Goods> responseEntityForDeleteGoods = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Goods.class,
                goods.getId()
        );

        assertEquals("OK", responseEntityForDeleteGoods.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeleteGoods.getBody());
    }

    @Test
    public void updateGoods() {
        Goods goods = createGoods();
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

    private Goods createGoods() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Goods goods = prefillGoods("test_object");

        HttpEntity<Goods> httpEntity = new HttpEntity<>(goods, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Goods createdGoods = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Goods.class
        ).getBody();

        assertNotNull(createdGoods);
        assertEquals(goods.getName(), createdGoods.getName());
        return createdGoods;
    }

    private Goods prefillGoods(String name) {
        Goods testGoods = new Goods();
//        testGoods.setName(name);
//        testGoods.setPrice(10);
//        testGoods.setStock(2);
//        testGoods.setCategoryDTO("something");
//        testGoods.setDate(new Date());
//        testGoods.setDescription("this line for test");
//        testGoods.setTagDTOS("qwerty");
//        testGoods.setSkuDTO("шт");
        return testGoods;
    }
}
