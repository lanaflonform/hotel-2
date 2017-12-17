package io.khasang.hotel.dao;

import io.khasang.hotel.entity.goods.Goods;

public interface GoodsDao extends BasicDao<Goods> {
    Goods deleteById(long id);
}
