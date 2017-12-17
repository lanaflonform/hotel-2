package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.GoodsDao;
import io.khasang.hotel.dto.goodsdto.GoodsDTO;
import io.khasang.hotel.entity.goods.Goods;
import io.khasang.hotel.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsDTO goodsDTO;

    @Override
    public List<GoodsDTO> getAllGoods() {
        return goodsDTO.getGoodsDTOList(goodsDao.getList());
    }

    @Override
    public Goods addGoods(Goods goods) {
        return (goodsDao.add(goods));
    }

    @Override
    public GoodsDTO getGoodsById(long id) {
        return goodsDTO.getGoodsDTO(goodsDao.getById(id));
    }

    @Override
    public Goods deleteGoods(long id) {
        return goodsDao.deleteById(id);
    }

    @Override
    public Goods updateGoods(Goods goods) {
        return (goodsDao.update(goods));
    }
}
