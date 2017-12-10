package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.GoodsDao;
import io.khasang.hotel.entity.goods.Goods;
import io.khasang.hotel.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getList();
    }

    @Override
    public Goods addGoods(Goods goods) {
        return goodsDao.add(goods);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsDao.getById(id);
    }

    @Override
    public Goods deleteGoods(int id) {
        return goodsDao.delete(getGoodsById(id));
    }

    @Override
    public Goods update(Goods goods) {
        return goodsDao.update(goods);
    }
}
