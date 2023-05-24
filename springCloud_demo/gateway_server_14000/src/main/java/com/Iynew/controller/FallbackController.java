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
    public CommonResult userFallback() {
        return new CommonResult(403, "商家服务异常", null);
    }


}