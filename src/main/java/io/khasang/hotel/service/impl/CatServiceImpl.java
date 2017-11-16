package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.CatDao;
import io.khasang.hotel.entity.Cat;
import io.khasang.hotel.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CatService")
public class CatServiceImpl implements CatService{
    @Autowired
    private CatDao catDao;

    @Override
    public List<Cat> getAllCats() {
        return catDao.getList();
    }

    @Override
    public Cat getCatById(long id) {
        return catDao.getById(id);
    }
}
