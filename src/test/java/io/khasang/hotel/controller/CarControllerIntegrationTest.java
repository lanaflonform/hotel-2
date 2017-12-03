package io.khasang.hotel.controller;

import io.khasang.hotel.dto.CarDTO;
import io.khasang.hotel.entity.Car;
import io.khasang.hotel.entity.Employee;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarControllerIntegrationTest {

    private final String ROOT = "http://localhost:8080/car";
    private final String ADD = "/add";
    private final String ALL = "/all";

    @Test
    public void addCat() {
        Car car = createCar();
        RestTemplate restTemplate = new RestTemplate();
    }

    @Test
    public void getCars() {
        createCar();
        createCar();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Set<CarDTO>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<CarDTO>>() {
                }
        );

        Set<CarDTO> catSet = responseEntity.getBody();

        assertNotNull(catSet);

    }

    private Car createCar() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Car car = prefillCar();

        HttpEntity<Car> httpEntity = new HttpEntity<>(car, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Car createdCar = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Car.class
        ).getBody();

        assertNotNull(createdCar);
        assertEquals(car.getModel(), createdCar.getModel());
        return createdCar;
    }

    private Car prefillCar() {
        Car car = new Car();
        car.setModel("Lada");
        car.setYear(LocalDate.of(2017, 1, 22));

        Employee employee1 = new Employee();
        employee1.setFirstName("Jack");
        employee1.setLastName("Vorobei");


        Employee employee2 = new Employee();
        employee2.setFirstName("Nick");
        employee2.setLastName("Jager");

        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);

        car.setEmployeeSet(employees);

        return car;
    }
}
