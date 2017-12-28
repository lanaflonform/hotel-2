package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.InfoDao;
import io.khasang.hotel.dto.InfoDTO;
import io.khasang.hotel.entity.Info;
import io.khasang.hotel.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("InfoService")
public class InfoServiceImpl implements InfoService{
    @Autowired
    private InfoDao infoDao;
    @Autowired
    private InfoDTO infoDTO;


    @Override
    public Set<InfoDTO> getAllInfo() {
        return infoDTO.getSetDto(infoDao.getSet());
    }

    @Override
    public Info getInfoById(long id) {
        return infoDao.getById(id);
    }

    @Override
    public Info addInfo(Info info) {
        return infoDao.add(info);
    }

    @Override
    public Info updateInfo(Info info) {
        return infoDao.update(info);
    }

    @Override
    public Info deleteInfo(long id) {
        return infoDao.delete(getInfoById(id));
    }
}
