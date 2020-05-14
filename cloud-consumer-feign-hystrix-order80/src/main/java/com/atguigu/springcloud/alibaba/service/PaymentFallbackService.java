package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/4/14
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "全局错误**********";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "全局错误**********";
    }
}
