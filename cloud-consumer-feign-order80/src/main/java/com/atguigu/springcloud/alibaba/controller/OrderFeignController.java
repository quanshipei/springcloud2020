package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.entites.CommonResult;
import com.atguigu.springcloud.alibaba.entites.Payment;
import com.atguigu.springcloud.alibaba.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/4/12
 */
@RestController
@RequestMapping("/customer/payment")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/{id}")
    public CommonResult<Payment> create(@PathVariable(value = "id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

}
