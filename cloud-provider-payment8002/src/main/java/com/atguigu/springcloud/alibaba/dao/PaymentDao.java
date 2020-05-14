package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author:quanshipei
 * @Date: 2020/3/30
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
