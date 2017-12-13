package io.khasang.hotel.dto.goodsdto;

import io.khasang.hotel.entity.goods.Goods;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoodsDTOTest {
    @Test
    public void getGoodsDTO() throws Exception {
        GoodsFactory goodsFactory = new GoodsFactory();
        Goods goods = goodsFactory.getTestGoods();

        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.getGoodsDTO(goods);

        assertEquals(goods.getName(), goodsDTO.getName());
        assertEquals(goods.getBarcode(), goodsDTO.getBarcode());
        assertEquals(goods.getDate(), goodsDTO.getDate());
        assertEquals(goods.getDescription(), goodsDTO.getDescription());
        assertEquals(goods.getPrice(), goodsDTO.getPrice());
        assertEquals(goods.getStock(), goodsDTO.getStock());
        assertEquals(goods.getTags().size(), goodsDTO.getTagDTOS().size());
        assertEquals(goods.getSku().getName(), goodsDTO.getSkuDTO().getName());
        assertTrue((goods.getManufacturer().getName()).equals(goodsDTO.getManufacturerDTO().getName()));
        assertEquals(goods.getCategory().getName(), goodsDTO.getCategoryDTO().getName());
    }

}