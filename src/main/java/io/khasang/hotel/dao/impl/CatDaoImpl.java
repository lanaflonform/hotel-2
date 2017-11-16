package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.CatDao;
import io.khasang.hotel.entity.Cat;

public class CatDaoImpl extends BasicDaoImpl<Cat> implements CatDao {

    public CatDaoImpl(Class<Cat> entityClass) {
        super(entityClass);
    }

}
