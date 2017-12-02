package io.khasang.hotel.service;

import io.khasang.hotel.entity.Car;

import java.util.Set;

public interface CarService {

    Car addCar(Car car);

    Set<Car> getSet();
}
