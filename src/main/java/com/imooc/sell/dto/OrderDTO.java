package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.entity.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import com.imooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/** Data Transfer Object 用于在各个层之间传输*/

/** 建立 这个类 主要就是 为了在 order_master 表中直观的看出表示 每个orderId 对应的 orderDetailList*/

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)      //只返回非空的字段   orderDetailList 有时不被查询   但是这个 可以被全局配置 代替   jackson:
//                                                                                                                            default-property-inclusion: non_null
public class OrderDTO {

    /** 订单id  */
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
    private Integer orderStatus;

    /** 支付状态 默认为0 未支付  */
    private Integer payStatus;

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)           //该注解是为了 调用该类把Date转Long （controller list() 方法中）
    private Date createTime;

    /** 更新时间  */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /** 建立 这个类 主要就是 为了表示这个
     *  因为之前 OrderMaster的每个属性要和数据库 order_master 表中一一对应
     *  但是 该表中没有 orderDetailList 这个属性
     *  所以 要新建一个 传输类 就是方便直接找到 一个orderId 对应的 orderDetail 们
     *
     */
    List<OrderDetail> orderDetailList;


    //该注解 在对象转JSON时忽略 因为我们不需要json传这些字段
    @JsonIgnore
    /**需要一个公用方法 传入int 值返回一个枚举*/
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
