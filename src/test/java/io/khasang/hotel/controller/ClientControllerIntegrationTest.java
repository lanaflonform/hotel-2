package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Address;
import io.khasang.hotel.entity.Client;
import io.khasang.hotel.entity.Phone;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/client";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete";
    private final String GET_BY_ID = "/get";

    @Test
    public void addClient() {
        Client client = createClient();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Client> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Client.class,
                client.getId()
        );

        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Client receivedClient = responseEntity.getBody();
        assertNotNull(receivedClient.getSecondName());
    }

    @Test
    public void getAllClient() {
        createClient();
        createClient();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Client>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Client>>() {
                }
        );
        List<Client> clientList = responseEntity.getBody();
        assertNotNull(clientList.get(0));
        assertNotNull(clientList.get(1));

    }

    @Test
    public void updateClient() {
        Client client = createClient();
        client.setName("Bobi");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Client> httpEntity = new HttpEntity<>(client, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Client> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Client.class
        );

        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Client receivedClient = responseEntity.getBody();
        assertNotNull(receivedClient.getFamily());
        assertEquals("Bobi", receivedClient.getName());
    }

    @Test
    public void deleteClient() {
        Client client = createClient();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Client> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Client.class,
                client.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Client receivedClient = responseEntity.getBody();
        assertNotNull(receivedClient.getFamily());

        ResponseEntity<Client> responseEntityForDeletedCat = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Client.class,
                client.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedCat.getBody());
    }

    private Client createClient() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Client client = prefillCall("Ivanov", "Bob", "Petrovich", "01.01.1990", "888-999-888");

        HttpEntity<Client> httpEntity = new HttpEntity<>(client, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Client createdClient = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Client.class
        ).getBody();

        assertNotNull(createdClient);
        Assert.assertEquals(client.getName(), createdClient.getName());
        return createdClient;
    }

    private Client prefillCall(String family, String name, String secondName, String date, String phone) {

        Phone phone1 = new Phone();
        phone1.setNumber(phone);
        Phone phone2 = new Phone();
        phone2.setNumber("222-33-66");
        Set<Phone> set = new HashSet<>();
        set.add(phone1);
        set.add(phone2);

        Address address1 = new Address("Koroleva", "10");
        Address address2 = new Address("Simonova", "1");
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ROOT);
        try {
            Date dateOfBirth = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Client bob = new Client();
        bob.setFamily(family);
        bob.setName(name);
        bob.setSecondName(secondName);
        bob.setDateOfBirth(LocalDate.of(2017, 11, 26));
        bob.setPhoneList(set);
        bob.setLevel(5);
        // bob.setAddresses(addressList);
        return bob;
    }
}
