package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.FireAlarmDao;
import io.khasang.hotel.entity.FireAlarm;
import io.khasang.hotel.service.FireAlarmService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FireAlarmServiceImpl implements FireAlarmService {
    @Autowired
    private FireAlarmDao fireAlarmDao;

    @Override
    public List<FireAlarm> getAllFireAlarm() {
        return fireAlarmDao.getList();
    }

    @Override
    public FireAlarm getFireAlarmById(long id) {
        return fireAlarmDao.getById(id);
    }

    @Override
    public FireAlarm addFireAlarm(FireAlarm fireAlarm) {
        return fireAlarmDao.add(fireAlarm);
    }

    @Override
    public FireAlarm deleteFireAlarm(long id) {
        return fireAlarmDao.delete(getFireAlarmById(id));
    }

}
