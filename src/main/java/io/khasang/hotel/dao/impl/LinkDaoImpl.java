package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.LinkDao;
import io.khasang.hotel.entity.Link;

public class LinkDaoImpl extends BasicDaoImpl<Link> implements LinkDao {
    public LinkDaoImpl(Class<Link> entityClass) {
        super(entityClass);
    }
}
