package io.khasang.hotel.dto.goodsdto;

import io.khasang.hotel.entity.goods.Goods;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoodsDTOGetGoodsUnitTest {
    @Test
    public void getGoodsDTO() throws Exception {
        Goods goods = (new GoodsFactoryForTests()).getTestGoods();

        GoodsDTO goodsDTO = (new GoodsDTO()).getGoodsDTO(goods);

        assertEquals(goods.getName(), goodsDTO.getName());
        assertEquals(goods.getBarcode(), goodsDTO.getBarcode());
        assertEquals(goods.getDate(), goodsDTO.getDate());
        assertEquals(goods.getDescription(), goodsDTO.getDescription());
        assertEquals(goods.getPrice(), goodsDTO.getPrice());
        assertEquals(goods.getStock(), goodsDTO.getStock());
        assertEquals(goods.getTags().size(), goodsDTO.getTagDTOS().size());
//        assertEquals(goods.getSku().getName(), goodsDTO.getSkuDTO().getName());
//        assertTrue((goods.getManufacturer().getName()).equals(goodsDTO.getManufacturerDTO().getName()));
//        assertEquals(goods.getCategory().getName(), goodsDTO.getCategoryDTO().getName());
    }

}