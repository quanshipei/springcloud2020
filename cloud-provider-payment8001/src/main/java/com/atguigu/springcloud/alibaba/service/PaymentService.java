package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.entites.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/3/30
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
