package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/3/30
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    public String servPort;

    @PostMapping()
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"插入成功,serverPort:"+servPort,payment);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping(value = "/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info("id={},{}",id,id);
        Payment payment=paymentService.getPaymentById(id);
        if(payment !=null){
            return new CommonResult(200,"查询成功,serverPort:"+servPort,payment);
        }else {
            return new CommonResult(444,"查询失败");
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services= discoveryClient.getServices();
        for(String service:services){
            log.info("***********service:{}",service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance instance:instances){
                log.info("instance:{}",instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"/\t"+instance.getUri());
            }
        }
        return discoveryClient;
    }

}
