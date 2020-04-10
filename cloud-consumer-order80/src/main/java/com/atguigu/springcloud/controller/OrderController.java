package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/3/31
 */
@RestController
@RequestMapping(value = "/customer/payment")
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE/payment/";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL,payment,CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> create(@PathVariable(value = "id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+id,CommonResult.class);
    }

    @GetMapping("/entity/{id}")
    public CommonResult<Payment> create1(@PathVariable(value = "id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }
        else{
            return new CommonResult<>(entity.getStatusCodeValue(),"操作失败");
        }
    }


}
