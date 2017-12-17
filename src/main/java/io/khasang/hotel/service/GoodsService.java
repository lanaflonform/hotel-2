package io.khasang.hotel.service;

import io.khasang.hotel.entity.goods.Goods;

import java.util.Set;

public interface GoodsService {
    /**
     * method for receiving all goods
     *
     * @return all goods
     */
    Set<Goods> getAllGoods();

    /**
     * @param goods - goods that should be added to DB
     * @return goods
     */
    Goods addGoods(Goods goods);

    /**
     * method for receiving goods by id
     *
     * @param id = goods id
     * @return Goods by id
     */
    Goods getGoodsById(long id);

    /**
     * method for delete goods by id
     *
     * @param id = goods id
     * @return deleted goods
     */
    Goods deleteGoods(long id);

    /**
     * @param goods - goods that should be updated
     * @return updated goods
     */
    Goods updateGoods(Goods goods);
}
