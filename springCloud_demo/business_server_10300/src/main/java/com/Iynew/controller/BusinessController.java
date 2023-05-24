package com.Iynew.controller;

import com.Iynew.feign.FoodFeignClient;
import com.Iynew.po.Business;
import com.Iynew.po.CommonResult;
import com.Iynew.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private FoodFeignClient foodFeignClient;

    @GetMapping("/listBusinessByOrderTypeId/{orderTypeId}")
    public CommonResult<List> listBusinessByOrderTypeId(@PathVariable("orderTypeId") Integer orderTypeId) throws Exception {
        List<Business> list = businessService.listBusinessByOrderTypeId(orderTypeId);
        return new CommonResult(200, "success", list);
    }

    @GetMapping("/getBusinessById/{businessId}")
    public CommonResult<Business> getBusinessById(@PathVariable("businessId") Integer businessId) throws Exception {


        Business business = businessService.getBusinessById(businessId);
        //在商家微服务中调用食品微服务
        CommonResult<List> result = foodFeignClient.listFoodByBusinessId(businessId);
        System.out.printf(result.getMessage());
        //如果食品微服务返回降级响应，那么就返回空集合
        if (result.getCode() == 200) {
            business.setFoodList(result.getResult());
        } else {
            business.setFoodList(new ArrayList());
        }
        return new CommonResult(200, "success", business);
    }
}