package io.khasang.hotel.controller;

import io.khasang.hotel.entity.User;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class UserControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/admin/user";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";
    private final String GET_BY_LOGIN = "/get/login";

    @Test
    public void addUser() {
        User user = createUser("test");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                User.class,
                user.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        User receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());
        deleteUser(user);
    }

    @Test
    public void userDelete() {
        User user = createUser("test");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                User.class,
                user.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        User receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());

        ResponseEntity<User> responseEntityForDeletedUser = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                User.class,
                user.getId()
        );

        assertEquals("OK", responseEntityForDeletedUser.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedUser.getBody());
    }

    @Test
    public void getAllUsers() {
        User user1 = createUser("test1");
        User user2 = createUser("test2");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        );

        List<User> userList = responseEntity.getBody();
        assertNotNull(userList.get(0));
        assertNotNull(userList.get(1));
        deleteUser(user1);
        deleteUser(user2);
    }

    @Test
    public void getUserByLogin() {
        User user = createUser("test");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_LOGIN + "/{login}",
                HttpMethod.GET,
                null,
                User.class,
                user.getLogin()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        User receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());
        assertEquals(user.getLogin(), receivedUser.getLogin());
        deleteUser(user);
    }

    @Test
    public void updateUser() {
        User user = createUser("test");
        user.setFirstName("TestUser");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                User.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        User receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());
        assertEquals("TestUser", receivedUser.getFirstName());
        deleteUser(user);
    }

    private User createUser(String login) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        User user = prefillCall(login);

        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        User createdUser = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                User.class
        ).getBody();

        assertNotNull(createdUser);
        assertEquals(user.getLogin(), createdUser.getLogin());
        return createdUser;
    }

    private void deleteUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                User.class,
                user.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
    }

    private User prefillCall(String login) {
        User user = new User();
        user.setLogin(login);
        user.setEmail(login + "@test.com");
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        return user;
    }
}
