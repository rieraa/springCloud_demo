package com.Iynew.controller;

import com.Iynew.po.CommonResult;
import com.Iynew.po.Orders;
import com.Iynew.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrdersController")
@RefreshScope
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/createOrders/{userId}/{businessId}/{daId}/{orderTotal}")
    public CommonResult<Integer> createOrders(@PathVariable("userId") String userId, @PathVariable("businessId") Integer businessId, @PathVariable("daId") Integer daId, @PathVariable("orderTotal") Double orderTotal) throws Exception {
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setBusinessId(businessId);
        orders.setDaId(daId);
        orders.setOrderTotal(orderTotal);
        int orderId = ordersService.createOrders(orders);
        return new CommonResult(200, "success（10601）", orderId);
    }

    @GetMapping("/getOrdersById/{orderId}")
    public CommonResult<Orders> getOrdersById(@PathVariable("orderId") Integer orderId) throws Exception {
        Orders orders = ordersService.getOrdersById(orderId);
        return new CommonResult(200, "success（10601）", orders);
    }

    @GetMapping("/listOrdersByUserId/{userId}")
    public CommonResult<List> listOrdersByUserId(@PathVariable("userId") String userId) throws Exception {
        List<Orders> list = ordersService.listOrdersByUserId(userId);
        return new CommonResult(200, "success（10601）", list);
    }
}