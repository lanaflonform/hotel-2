package io.khasang.hotel.controller;

import io.khasang.hotel.dto.RoleDTO;
import io.khasang.hotel.dto.UserDTO;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/admin/users";
    private static final String GET_BY_LOGIN = "?login=";
    private static final String GET_BY_EMAIL = "?email=";

    @Test
    public void addUserAndGetById() {
        UserDTO userDTO = createUser("test");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + "/{id}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        UserDTO receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getId());
        deleteUser(userDTO);
    }

    @Test
    public void get404WhenRequestNonexistentId() {
        UserDTO userDTO = new UserDTO(9999L, "", "", "", null, "",
                "", false, null);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) {
            }
        });

        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + "/{id}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getId()
        );

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void userDelete() {
        UserDTO userDTO = createUser("test");
        ResponseEntity<UserDTO> responseEntity = deleteUser(userDTO);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) {
            }
        });

        responseEntity = restTemplate.exchange(
                ROOT + "/{id}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getId()
        );

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void get404WhenDeleteNonexistentUser() {
        UserDTO userDTO = new UserDTO(9999L, "", "", "", null, "",
                "", false, null);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) {
            }
        });

        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + "/{id}",
                HttpMethod.DELETE,
                null,
                UserDTO.class,
                userDTO.getId()
        );

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void getAllUsers() {
        UserDTO user1 = createUser("test1");
        UserDTO user2 = createUser("test2");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Set<UserDTO>> responseEntity = restTemplate.exchange(
                ROOT,
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
                ROOT + GET_BY_LOGIN + "{login}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getLogin()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        UserDTO receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());
        assertEquals(userDTO.getLogin(), receivedUser.getLogin());
        deleteUser(userDTO);
    }

    @Test
    public void get404WhenRequestNonexistentLogin() {
        UserDTO userDTO = new UserDTO(9999L, "", "", "", null, "NonexistentLogin",
                "", false, null);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) {
            }
        });

        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_LOGIN + "{login}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getLogin()
        );

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void getUserByEmail() {
        UserDTO userDTO = createUser("test");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_EMAIL + "{email}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getEmail()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        UserDTO receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getEmail());
        assertEquals(userDTO.getEmail(), receivedUser.getEmail());
        deleteUser(userDTO);
    }

    @Test
    public void get404WhenRequestNonexistentEmail() {
        UserDTO userDTO = new UserDTO(9999L, "", "", "NonexistentEmail", null, "",
                "", false, null);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) {
            }
        });

        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_EMAIL + "{email}",
                HttpMethod.GET,
                null,
                UserDTO.class,
                userDTO.getEmail()
        );

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
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
                ROOT,
                HttpMethod.PUT,
                httpEntity,
                UserDTO.class
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        UserDTO receivedUser = responseEntity.getBody();
        assertNotNull(receivedUser.getLogin());
        assertEquals(userDTO.getFirstName(), receivedUser.getFirstName());
        deleteUser(userDTO);
    }

    @Test
    public void get404WhenUpdateNonexistentUser() {
        UserDTO userDTO = new UserDTO(9999L, "", "", "", null, "",
                "", false, null);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(userDTO, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) {
            }
        });

        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                ROOT,
                HttpMethod.PUT,
                httpEntity,
                UserDTO.class
        );

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    private UserDTO createUser(String login) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        UserDTO userDTO = prefillCall(login);

        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(userDTO, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> createdUser = restTemplate.exchange(
                ROOT,
                HttpMethod.POST,
                httpEntity,
                UserDTO.class
        );

        assertEquals(HttpStatus.CREATED, createdUser.getStatusCode());
        assertNotNull(createdUser.getBody());
        assertEquals(userDTO.getLogin(), createdUser.getBody().getLogin());
        return createdUser.getBody();
    }

    private ResponseEntity<UserDTO> deleteUser(UserDTO userDTO) {
        return new RestTemplate().exchange(
                ROOT + "/{id}",
                HttpMethod.DELETE,
                null,
                UserDTO.class,
                userDTO.getId()
        );
    }

    private UserDTO prefillCall(String login) {
        Set<RoleDTO> rolesDTO = new HashSet<>();
        rolesDTO.add(new RoleDTO(null, "TestRole1", "Description for test role1"));
        rolesDTO.add(new RoleDTO(null, "TestRole2", "Description for test role2"));

        return new UserDTO(null, "testFirstName", "testLastName", login + "@test.com",
                LocalDate.now(), login, "SecretPassword", false, rolesDTO);

    }
}
