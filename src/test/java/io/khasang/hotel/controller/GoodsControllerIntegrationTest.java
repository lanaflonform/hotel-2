package io.khasang.hotel.controller;

import io.khasang.hotel.dto.goodsdto.GoodsDTO;
import io.khasang.hotel.entity.goods.Category;
import io.khasang.hotel.entity.goods.Goods;
import io.khasang.hotel.entity.goods.Sku;
import io.khasang.hotel.entity.goods.Tag;
import io.khasang.hotel.entity.goods.manufacturer.Manufacturer;
import io.khasang.hotel.entity.goods.manufacturer.Person;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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
        testGoods.setName(name);
        testGoods.setSku(createSku());
        testGoods.setManufacturer(createManufacturer());
        testGoods.setBarcode(1234567898765L);
        testGoods.setPrice(1001);
        testGoods.setStock(24);
        testGoods.setDescription("this line for test");
        testGoods.setDate(new Date());
        testGoods.setCategory(createCategory());
        testGoods.setTags(createTagSet());
        return testGoods;
    }

    private Set<Tag> createTagSet() {
        Set<Tag> tagSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            Tag tag = new Tag();
            tag.setName("test tag" + i);
            tagSet.add(tag);
        }
        return tagSet;
    }

    private Category createCategory() {
        Category category = new Category();
        category.setName("test category");
        return category;
    }

    private Manufacturer createManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("test manufacturer");
        manufacturer.setAddress("test address");
        manufacturer.setPhone("333-222");
        manufacturer.setEmail("test@mail.io");
        manufacturer.setContactList(createContactList());
        return manufacturer;
    }

    private List<Person> createContactList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Person person = new Person();
            person.setFirstName("Test first name " + i);
            person.setLastName("Test last name " + i);
            person.setPosition("test position");
            person.setPhone1("234-456-" + i);
            person.setPhone2("335-6783-" + i);
            person.setEmail1("test@mail.ru");
            person.setEmail2("test21@mail.ru");
            personList.add(person);
        }
        return personList;
    }

    private Sku createSku() {
        Sku sku = new Sku();
        sku.setName("kg");
        return sku;
    }
}
