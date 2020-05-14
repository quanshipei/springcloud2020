package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.entites.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/4/12
 */
@Component
@FeignClient(value = "cloud-payment-service")
@RequestMapping(value = "/payment")
public interface PaymentFeignService {
    @GetMapping(value = "/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);
}
