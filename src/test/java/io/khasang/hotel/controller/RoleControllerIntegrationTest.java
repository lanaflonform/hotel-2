package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Role;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class RoleControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/role";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";

    @Test
    public void addRole() {
        Role role = createRole();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Role.class,
                role.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Role receivedRole = responseEntity.getBody();
        assertNotNull(receivedRole.getDescription());
    }

    @Test
    public void roleDelete() {
        Role role = createRole();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Role.class,
                role.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Role receivedRole = responseEntity.getBody();
        assertNotNull(receivedRole.getDescription());

        ResponseEntity<Role> responseEntityForDeletedRole = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Role.class,
                role.getId()
        );

        assertEquals("OK", responseEntityForDeletedRole.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedRole.getBody());

    }

    @Test
    public void getAllRoles() {
        createRole();
        createRole();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Role>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Role>>() {
                }
        );

        List<Role> roleList = responseEntity.getBody();
        assertNotNull(roleList.get(0));
        assertNotNull(roleList.get(1));

    }

    private Role createRole() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Role role = prefillCall("Admin");

        HttpEntity<Role> httpEntity = new HttpEntity<>(role, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Role createdRole = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Role.class
        ).getBody();

        assertNotNull(createdRole);
        assertEquals(role.getName(), createdRole.getName());
        return createdRole;
    }

    @Test
    public void updateRole() {
        Role role = createRole();
        role.setName("User");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Role> httpEntity = new HttpEntity<>(role, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Role.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Role receivedRole = responseEntity.getBody();
        assertNotNull(receivedRole.getDescription());
        assertEquals("User", receivedRole.getName());
    }

    private Role prefillCall(String name) {
        Role superRole = new Role();
        superRole.setName(name);
        superRole.setDescription("Super Role");
        return superRole;
    }

}