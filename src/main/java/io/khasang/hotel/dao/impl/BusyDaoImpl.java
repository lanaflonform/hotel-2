package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.BusyDao;
import io.khasang.hotel.entity.Busy;

public class BusyDaoImpl extends BasicDaoImpl<Busy> implements BusyDao {
    public BusyDaoImpl(Class<Busy> entityClass) {
        super(entityClass);
    }
}
