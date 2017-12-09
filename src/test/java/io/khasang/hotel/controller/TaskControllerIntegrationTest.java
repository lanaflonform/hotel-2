package io.khasang.hotel.controller;

import io.khasang.hotel.dto.TaskDTO;
import io.khasang.hotel.entity.Task;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;

public class TaskControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/task";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";

    @Test
    public void addCat() {
        Task task = createTask();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Task> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Task.class,
                task.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Task receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getBid());
    }

    @Test
    public void catDelete() {
        Task task = createTask();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Task> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Task.class,
                task.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Task receivedTask = responseEntity.getBody();
        assertNotNull(receivedTask.getBid());

        ResponseEntity<Task> responseEntityForDeletedTask = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Task.class,
                task.getId()
        );

        assertEquals("OK", responseEntityForDeletedTask.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedTask.getBody());

    }

    @Test
    public void getAllTasks() {
        createTask();
        createTask();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Set<TaskDTO>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<TaskDTO>>() {
                }
        );

        Set<TaskDTO> taskSet = responseEntity.getBody();
        assertNotNull(taskSet);
    }

    private Task createTask() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Task task = prefillCall("Vasya");

        HttpEntity<Task> httpEntity = new HttpEntity<>(task, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Task createdTask = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Task.class
        ).getBody();

        assertNotNull(createdTask);
        assertEquals(task.getName(), createdTask.getName());
        return createdTask;
    }

    @Test
    public void updateTask() {
        Task task = createTask();
        task.setName("Vasya");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Task> httpEntity = new HttpEntity<>(task, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Task> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Task.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Task receivedTask = responseEntity.getBody();
        assertNotNull(receivedTask.getBid());
        assertEquals("Vasya", receivedTask.getName());
    }

    private Task prefillCall(String name) {
        Task toDo = new Task();
        toDo.setName(name);
        toDo.setBid("To DO");
        toDo.setCreatedAt(LocalDate.of(2017, 1, 22));
        toDo.setCompleted(LocalDate.of(2017, 1, 22));
        return toDo;
    }
}
