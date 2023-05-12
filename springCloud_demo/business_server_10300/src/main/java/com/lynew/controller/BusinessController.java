package com.lynew.controller;

import com.lynew.po.Business;
import com.lynew.po.CommonResult;
import com.lynew.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/listBusinessByOrderTypeId/{orderTypeId}")
    public CommonResult<List> listBusinessByOrderTypeId(@PathVariable("orderTypeId") Integer orderTypeId) throws Exception {
        List<Business> list = businessService.listBusinessByOrderTypeId(orderTypeId);
        return new CommonResult(200, "success", list);
    }

    @GetMapping("/getBusinessById/{businessId}")
    public CommonResult<Business> getBusinessById(@PathVariable("businessId") Integer businessId) throws Exception {
        Business business = businessService.getBusinessById(businessId);
        //在商家微服务中调用食品微服务
            CommonResult<List> result = restTemplate.getForObject("http://localhost:10200/FoodController/listFoodByBusinessId/" + businessId, CommonResult.class);
        if (result.getCode() == 200) {
            business.setFoodList(result.getResult());
        }
        return new CommonResult(200, "success", business);
    }
}