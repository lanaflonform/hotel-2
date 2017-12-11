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
    public Set<GoodsDTO> getAllGoods() {
        return goodsDTO.getGoodsDTOSet(goodsDao.getSet());
    }

    @Override
    public Goods addGoods(Goods goods) {
        return goodsDao.add(goods);
    }

    @Override
    public GoodsDTO getGoodsById(int id) {
        return goodsDTO.getGoodsDTO(goodsDao.getById(id));
    }

    @Override
    public GoodsDTO deleteGoods(int id) {
        return goodsDTO.getGoodsDTO(goodsDao.delete(id));
    }

    @Override
    public Goods update(Goods goods) {
        return goodsDao.update(goods);
    }
}
