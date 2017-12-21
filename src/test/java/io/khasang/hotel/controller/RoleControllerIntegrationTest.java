package io.khasang.hotel.controller;

import io.khasang.hotel.dto.RoleDTO;
import io.khasang.hotel.dto.UserDTO;
import io.khasang.hotel.entity.Role;
import io.khasang.hotel.entity.User;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        RoleDTO roleDTO = createRole();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RoleDTO> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                RoleDTO.class,
                roleDTO.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        RoleDTO receivedRole = responseEntity.getBody();
        assertNotNull(receivedRole.getDescription());
    }

    @Test
    public void roleDelete() {
        RoleDTO roleDTO = createRole();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RoleDTO> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                RoleDTO.class,
                roleDTO.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        RoleDTO receivedRole = responseEntity.getBody();
        assertNotNull(receivedRole.getDescription());

        ResponseEntity<RoleDTO> responseEntityForDeletedRole = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                RoleDTO.class,
                roleDTO.getId()
        );

        assertEquals("OK", responseEntityForDeletedRole.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedRole.getBody());
    }

    @Test
    public void getAllRoles() {
        createRole();
        createRole();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<RoleDTO>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RoleDTO>>() {
                }
        );

        List<RoleDTO> roleList = responseEntity.getBody();
        assertNotNull(roleList.get(0));
        assertNotNull(roleList.get(1));
    }

    @Test
    public void addUser() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RoleDTO roleDTO1 = createRole("STAFF");
        RoleDTO roleDTO2 = createRole("AD");
        Set<RoleDTO> roles = new HashSet<>();
        roles.add(roleDTO1);
        roles.add(roleDTO2);
        UserDTO userDTO = new UserDTO(null, "Sanya", "", "1@1.ru", LocalDate.now(), "sanya", "sanya", true, roles);

        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(userDTO, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                "http://localhost:8080/admin/users",
                HttpMethod.POST,
                httpEntity,
                UserDTO.class
        );

        assertEquals("Created", responseEntity.getStatusCode().getReasonPhrase());
        UserDTO receivedUserDTO = responseEntity.getBody();
        assertNotNull(receivedUserDTO.getId());
    }

    private RoleDTO createRole(String name) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RoleDTO roleDTO = prefillCall(name);

        HttpEntity<RoleDTO> httpEntity = new HttpEntity<>(roleDTO, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        RoleDTO createdRole = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                RoleDTO.class
        ).getBody();

        assertNotNull(createdRole);
        assertEquals(roleDTO.getName(), createdRole.getName());
        return createdRole;
    }

    private RoleDTO createRole() {
        return createRole("Admin");
    }

    @Test
    public void updateRole() {
        RoleDTO roleDTO = createRole();
        roleDTO.setName("User");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<RoleDTO> httpEntity = new HttpEntity<>(roleDTO, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RoleDTO> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                RoleDTO.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        RoleDTO receivedRole = responseEntity.getBody();
        assertNotNull(receivedRole.getDescription());
        assertEquals("User", receivedRole.getName());
    }

    private RoleDTO prefillCall(String name) {
        return new RoleDTO(null, name, "Super Role");
    }
}
