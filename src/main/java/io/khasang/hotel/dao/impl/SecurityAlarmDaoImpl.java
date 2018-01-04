package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.SecurityAlarmDao;
import io.khasang.hotel.entity.SecurityAlarm;

public class SecurityAlarmDaoImpl extends BasicDaoImpl<SecurityAlarm> implements SecurityAlarmDao {
    public SecurityAlarmDaoImpl(Class<SecurityAlarm> entityClass) {
        super(entityClass);
    }
}
