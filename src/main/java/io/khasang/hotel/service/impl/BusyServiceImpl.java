package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.BusyDao;
import io.khasang.hotel.entity.Busy;
import io.khasang.hotel.service.BusyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("Busy")
public class BusyServiceImpl implements BusyService {
    @Autowired
    private BusyDao busyDao;

    @Override
    public List<Busy> getAllbusyRoom() {
        return busyDao.getList();
    }

    @Override
    public Busy getBusyById(long id) {
        return busyDao.getById(id);
    }

    @Override
    public Busy addBusy(Busy busy) {
        return busyDao.add(busy);
    }

    @Override
    public Busy deleteBusy(long id) {
        return busyDao.delete(getBusyById(id));
    }

}
