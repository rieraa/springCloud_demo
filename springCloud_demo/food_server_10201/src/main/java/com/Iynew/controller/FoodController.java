package com.Iynew.controller;

import java.util.List;

import com.Iynew.po.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.Iynew.po.CommonResult;

import com.Iynew.service.FoodService;

@RestController
@RequestMapping("/FoodController")
@RefreshScope
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/listFoodByBusinessId/{businessId}")
    public CommonResult<List> listFoodByBusinessId(@PathVariable("businessId") Integer businessId) throws Exception {
        List<Food> list = foodService.listFoodByBusinessId(businessId);
        return new CommonResult(200, "success(10201)", list);
    }
}