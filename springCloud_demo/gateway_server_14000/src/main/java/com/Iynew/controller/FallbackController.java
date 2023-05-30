package com.Iynew.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Iynew.po.CommonResult;

@RestController

public class FallbackController {
    @RequestMapping("/fallback")
    public CommonResult fallback() {
        return new CommonResult(403, "服务异常", null);
    }

    @RequestMapping("/fallback/business")
    public CommonResult businessFallback() {
        return new CommonResult(403, "商家服务异常", null);
    }

    @RequestMapping("/fallback/user")
    public CommonResult userFallback() {
        return new CommonResult(403, "用户服务异常", null);
    }

    @RequestMapping("/fallback/cart")
    public CommonResult cartFallback() {
        return new CommonResult(403, "购物车服务异常", null);
    }

    @RequestMapping("/fallback/delivery")
    public CommonResult deliveryFallback() {
        return new CommonResult(403, "地址服务异常", null);


    }

    @RequestMapping("/fallback/order")
    public CommonResult orderFallback() {
        return new CommonResult(403, "订单服务异常", null);


    }


}