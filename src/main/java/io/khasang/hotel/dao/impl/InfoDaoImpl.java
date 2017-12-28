package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.InfoDao;
import io.khasang.hotel.entity.Info;

public class InfoDaoImpl extends BasicDaoImpl<Info> implements InfoDao {
    public InfoDaoImpl(Class<Info> entityClass) {
        super(entityClass);
    }
}
