package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Client;
import javafx.scene.input.DataFormat;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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
        assertNotNull(receivedClient.getFamily());
    }

    @Test
    public void getAllClient(){
        createClient();
        createClient();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Client>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Client>>(){
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
        Client receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getFamily());
        assertEquals("Bobi", receivedCat.getName());
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
        Client receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getFamily());

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

        Client client = null;
        try {
            client = prefillCall("Ivanov", "Bob" , "Petrovich", "01.01.1990", "888-999-888");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        HttpEntity<Client> httpEntity = new HttpEntity<>(client, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Client createClient = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Client.class
        ).getBody();
        assertNotNull(createClient);
        Assert.assertEquals(client.getFamily(), createClient.getFamily());
        return createClient;
    }

    private Client prefillCall(String family,String name, String secondName, String date, String phone ) throws ParseException {
        Client bob = new Client();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ROOT);
        Date dateOfBirth =  format.parse(date);
        bob.setFamily(family);
        bob.setName(name);
        bob.setSecondName(secondName);
        bob.setDateOfBirth(dateOfBirth);
        bob.setPhone(phone);
        bob.setLevel(5);
        return bob;
    }
}
