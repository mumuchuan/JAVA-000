package io.kimmking.cache.controller;

import io.kimmking.cache.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class GoodsBuyController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/buy")
    public Integer buy(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        return goodsService.buy(id);
    }

    @RequestMapping("/goodsStock")
    public Integer goodsStock(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        return goodsService.stock(id);
    }
}