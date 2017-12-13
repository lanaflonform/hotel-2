package io.khasang.hotel.controller;

import io.khasang.hotel.dto.goodsdto.GoodsDTO;
import io.khasang.hotel.dto.goodsdto.GoodsFactory;
import io.khasang.hotel.entity.goods.Goods;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

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
        ResponseEntity<Set<GoodsDTO>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<GoodsDTO>>() {
                }
        );

        Set<GoodsDTO> goodsDTOSet = responseEntity.getBody();
        assertNotNull(goodsDTOSet);
    }

    @Test
    public void deleteGoods() {
        Goods goods = createGoods();

        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.getGoodsDTO(goods);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GoodsDTO> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                GoodsDTO.class,
                goods.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        GoodsDTO receivedGoods = responseEntity.getBody();
        assertNotNull(receivedGoods.getName());

        ResponseEntity<Goods> responseEntityForDeleteGoods = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Goods.class,
                goods.getId()
        );

        //assertEquals("OK", responseEntityForDeleteGoods.getStatusCode().getReasonPhrase());
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

        GoodsFactory goodsFactory = new GoodsFactory();
        Goods goods = goodsFactory.getTestGoods();

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
}
