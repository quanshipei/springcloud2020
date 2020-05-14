package com.atguigu.springcloud.alibaba;

import com.atguigu.springcloud.alibaba.service.IMessageProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/4/16
 */
@SpringBootApplication
@RestController
public class StreamMQMain8801 {
    public static void main(String[] args)
    {
        SpringApplication.run(StreamMQMain8801.class,args);
    }

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }
}
