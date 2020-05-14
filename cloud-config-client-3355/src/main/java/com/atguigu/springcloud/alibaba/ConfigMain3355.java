package com.atguigu.springcloud.alibaba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/4/15
 */
@SpringBootApplication
@RestController
@RefreshScope
public class ConfigMain3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3355.class,args);
    }

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
