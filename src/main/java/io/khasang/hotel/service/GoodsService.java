package io.khasang.hotel.service;

import io.khasang.hotel.dto.goodsdto.GoodsDTO;
import io.khasang.hotel.entity.goods.Goods;

import java.util.Set;

public interface GoodsService {
    /**
     * method for receiving all goods
     *
     * @return all goods
     */
    Set<GoodsDTO> getAllGoods();

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
    GoodsDTO getGoodsById(int id);

    /**
     * method for delete goods by id
     *
     * @param id = goods id
     * @return deleted goods
     */
    GoodsDTO deleteGoods(int id);

    /**
     * @param goods - goods that should be updated
     * @return updated goods
     */
    Goods update(Goods goods);
}
