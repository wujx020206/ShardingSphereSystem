package com.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 订单表
 */
@Data
@ToString
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 661434701950670670L;

    @TableId
    private Long orderId;

    private Integer userId;

    private Long addressId;

    private String status;
}