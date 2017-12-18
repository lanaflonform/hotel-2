package io.khasang.hotel.dao;

import io.khasang.hotel.entity.goods.Goods;

public interface GoodsDao extends BasicDao<Goods> {
    /**
     * @param id - goods's id for remove
     * @return  deleted goods
     * */
    Goods deleteById(long id);

}
