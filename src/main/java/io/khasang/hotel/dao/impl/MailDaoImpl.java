package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.MailDao;
import io.khasang.hotel.entity.Mail;

public class MailDaoImpl extends BasicDaoImpl<Mail> implements MailDao {
    public MailDaoImpl(Class<Mail> entityClass) {
        super(entityClass);
    }
}
