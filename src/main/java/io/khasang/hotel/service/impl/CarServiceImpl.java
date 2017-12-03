package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.CarDao;
import io.khasang.hotel.dto.CarDTO;
import io.khasang.hotel.entity.Car;
import io.khasang.hotel.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    @Autowired
    private CarDTO carDTO;

    @Override
    public Car addCar(Car car) {
        return carDao.add(car);
    }

    @Override
    public Set<CarDTO> getSet() {
        return carDTO.getCarDTO(carDao.getSet());
    }
}
