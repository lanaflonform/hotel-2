package io.khasang.hotel.service;

import io.khasang.hotel.entity.Goods;

import java.util.List;

public interface GoodsService {
    /**
     * method for receiving all goods
     *
     * @return all goods
     */
    List<Goods> getAllGoods();

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
    Goods getGoodsById(int id);

    /**
     * method for delete goods by id
     *
     * @param id = goods id
     * @return deleted goods
     */
    Goods deleteGoods(int id);

    /**
     * @param goods - goods that should be updated
     * @return updated goods
     */
    Goods update(Goods goods);
}
