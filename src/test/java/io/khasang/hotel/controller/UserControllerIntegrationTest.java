package io.khasang.hotel.controller;

import io.khasang.hotel.dto.RoleDTO;
import io.khasang.hotel.dto.UserDTO;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class UserControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/admin/user";
    private static final String ADD = "/add";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";
    private static final String GET_BY_ID = "/get";
    private static final String GET_BY_LOGIN = "/get/login";

    @Test
    public void addUser() {
        UserDTO userDTO = createUser("test");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        UserDTO receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());
        deleteUser(userDTO);
    }

    @Test
    public void userDelete() {
        UserDTO userDTO = createUser("test");
        UserDTO receivedUser = deleteUser(userDTO).getBody();
        assertNotNull(receivedUser.getLogin());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> responseEntityForDeletedUser = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getId()
        );

        assertEquals("OK", responseEntityForDeletedUser.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedUser.getBody());
    }

    @Test
    public void getAllUsers() {
        UserDTO user1 = createUser("test1");
        UserDTO user2 = createUser("test2");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Set<UserDTO>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<UserDTO>>() {
                }
        );

        Set<UserDTO> userSet = responseEntity.getBody();
        assertNotNull(userSet);
        assertEquals(2, userSet.size());
        deleteUser(user1);
        deleteUser(user2);
    }

    @Test
    public void getUserByLogin() {
        UserDTO userDTO = createUser("test");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_LOGIN + "/{login}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getLogin()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        UserDTO receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());
        assertEquals(userDTO.getLogin(), receivedUser.getLogin());
        deleteUser(userDTO);
    }

    @Test
    public void updateUser() {
        UserDTO userDTO = createUser("test");
        userDTO.setFirstName("TestUser");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(userDTO, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                UserDTO.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        UserDTO receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());
        assertEquals("TestUser", receivedUser.getFirstName());
        deleteUser(userDTO);
    }

    private UserDTO createUser(String login) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        UserDTO userDTO = prefillCall(login);

        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(userDTO, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        UserDTO createdUser = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                UserDTO.class
        ).getBody();

        assertNotNull(createdUser);
        assertEquals(userDTO.getLogin(), createdUser.getLogin());
        return createdUser;
    }

    private ResponseEntity<UserDTO> deleteUser(UserDTO userDTO) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                UserDTO.class,
                userDTO.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        return responseEntity;
    }

    private UserDTO prefillCall(String login) {
        Set<RoleDTO> rolesDTO = new HashSet<>();
        rolesDTO.add(new RoleDTO(null, "TestRole1", "Description for test role1"));
        rolesDTO.add(new RoleDTO(null, "TestRole2", "Description for test role2"));

        return new UserDTO(null, "testFirstName", "testLastName", login + "@test.com",
                LocalDate.now(), login, "SecretPassword", false, rolesDTO);

    }
}
