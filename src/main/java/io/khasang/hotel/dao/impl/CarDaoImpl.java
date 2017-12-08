package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.CarDao;
import io.khasang.hotel.entity.Car;

public class CarDaoImpl extends BasicDaoImpl<Car> implements CarDao {

    public CarDaoImpl(Class<Car> entityClass) {
        super(entityClass);
    }
}
