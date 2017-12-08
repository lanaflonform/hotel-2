package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Goods;
import io.khasang.hotel.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    public GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Goods> getAllGoods() {
        return goodsService.getAllGoods();
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Goods getGoodsById(@PathVariable(value = "id") String id) {
        return goodsService.getGoodsById(Integer.parseInt(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Goods addGoods(@RequestBody Goods goods) {
        return goodsService.addGoods(goods);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Goods deleteGoods(@RequestParam(value = "id") String id) {
        return goodsService.deleteGoods(Integer.parseInt(id));
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Goods updateGoods(@RequestBody Goods goods) {
        return goodsService.update(goods);
    }
}

