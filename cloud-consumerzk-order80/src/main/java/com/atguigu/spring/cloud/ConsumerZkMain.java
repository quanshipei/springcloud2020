package com.atguigu.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/4/8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkMain.class,args);
    }
}
