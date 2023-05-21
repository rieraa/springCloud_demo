package com.Iynew.controller;

import com.Iynew.po.Business;
import com.Iynew.po.CommonResult;
import com.Iynew.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/listBusinessByOrderTypeId/{orderTypeId}")
    public CommonResult<List> listBusinessByOrderTypeId(@PathVariable("orderTypeId") Integer orderTypeId) throws Exception {
        List<Business> list = businessService.listBusinessByOrderTypeId(orderTypeId);
        return new CommonResult(200, "success", list);
    }

    @GetMapping("/getBusinessById/{businessId}")
    public CommonResult<Business> getBusinessById(@PathVariable("businessId") Integer businessId) throws Exception {
        //通过服务提供者名（food-server）获取Eureka Server上的元数据
        List<ServiceInstance> instanceList = discoveryClient.getInstances("food-server");
        //现在，元数据集合中只有一个服务信息（food-server）
        ServiceInstance instance = instanceList.get(0);

        Business business = businessService.getBusinessById(businessId);
        //在商家微服务中调用食品微服务
        CommonResult<List> result = restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/FoodController/listFoodByBusinessId / " + businessId, CommonResult.class);

        if (result.getCode() == 200) {
            business.setFoodList(result.getResult());
        }
        return new CommonResult(200, "success", business);
    }
}