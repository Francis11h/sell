package com.imooc.sell.entity;


import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
/** 该注解 自动更新 updateTime*/
@DynamicUpdate
public class OrderMaster {

    /** 订单id  */
    @Id                 //主键的注解 也不能省
    private String orderId;

    /** 买家姓名  */
    private String buyerName;

    /** 买家手机号  */
    private String buyerPhone;

    /** 买家地址  */
    private String buyerAddress;

    /** 买家微信openid  */
    private String buyerOpenid;

    /** 订单总金额  */
    private BigDecimal orderAmount;

    /** 订单状态  默认新订单  */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态 默认为0 未支付  */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 更新时间  */
    private Date updateTime;

}
