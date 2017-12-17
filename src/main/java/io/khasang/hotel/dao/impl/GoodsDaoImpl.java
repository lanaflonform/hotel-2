package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.GoodsDao;
import io.khasang.hotel.entity.goods.Goods;

public class GoodsDaoImpl extends BasicDaoImpl<Goods> implements GoodsDao {
    public GoodsDaoImpl(Class<Goods> entityClass) {
        super(entityClass);
    }

}
