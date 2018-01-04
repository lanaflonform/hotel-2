package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.PhoneDao;
import io.khasang.hotel.entity.Phone;

public class PhoneDaoImpl extends BasicDaoImpl<Phone> implements PhoneDao {
    public PhoneDaoImpl(Class<Phone> entityClass) {
        super(entityClass);
    }
}
