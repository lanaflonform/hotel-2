package io.khasang.hotel.dao;

import io.khasang.hotel.entity.goods.Goods;

public interface GoodsDao extends BasicDao<Goods> {

    Goods delete(int id);
}
