package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.GoodsDao;
import io.khasang.hotel.dto.goodsdto.GoodsDTO;
import io.khasang.hotel.entity.goods.Goods;
import io.khasang.hotel.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsDTO goodsDTO;

    @Override
    public Set<Goods> getAllGoods() {
       // return goodsDTO.getGoodsDTOSet(goodsDao.getSet());
        return (goodsDao.getSet());
    }

    @Override
    public Goods addGoods(Goods goods) {
        //return goodsDTO.getGoodsDTO(goodsDao.add(goods));
        return (goodsDao.add(goods));
    }

    @Override
    public Goods getGoodsById(long id) {
        //return goodsDTO.getGoodsDTO(goodsDao.getById(id));
        return (goodsDao.getById(id));
    }

    @Override
    public Goods deleteGoods(long id) {
        //return goodsDTO.getGoodsDTO(goodsDao.delete(id));
        return (goodsDao.delete(getGoodsById(id)));
    }

    @Override
    public Goods updateGoods(Goods goods) {
        //return goodsDTO.getGoodsDTO(goodsDao.update(goods));
        return (goodsDao.update(goods));
    }
}
