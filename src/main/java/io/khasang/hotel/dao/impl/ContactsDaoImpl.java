package io.khasang.hotel.dao.impl;

import io.khasang.hotel.entity.Contacts;
import io.khasang.hotel.dao.ContactsDao;

public class ContactsDaoImpl extends BasicDaoImpl<Contacts> implements ContactsDao {
    public ContactsDaoImpl(Class<Contacts> entityClass) {
        super(entityClass);
    }
}
