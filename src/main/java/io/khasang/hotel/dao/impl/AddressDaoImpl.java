package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.AddressDao;
import io.khasang.hotel.entity.Address;

public class AddressDaoImpl extends BasicDaoImpl<Address> implements AddressDao {
    public AddressDaoImpl(Class<Address> entityClass) {
        super(entityClass);
    }
}
