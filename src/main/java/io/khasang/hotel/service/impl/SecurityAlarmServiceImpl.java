package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.SecurityAlarmDao;
import io.khasang.hotel.entity.SecurityAlarm;
import io.khasang.hotel.service.SecurityAlarmService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SecurityAlarmServiceImpl implements SecurityAlarmService {
    @Autowired
    private SecurityAlarmDao securityAlarmDao;
    @Override
    public List<SecurityAlarm> getAllSecurityAlarm() {
        return securityAlarmDao.getList();
    }

    @Override
    public SecurityAlarm getSecurityAlarmById(long id) {
        return securityAlarmDao.getById(id);
    }

    @Override
    public SecurityAlarm addSecurityAlarm(SecurityAlarm securityAlarm) {
        return securityAlarmDao.add(securityAlarm);
    }

    @Override
    public SecurityAlarm deleteSecurityAlarm(long id) {
        return securityAlarmDao.delete(getSecurityAlarmById(id));
    }
}
