package com.imooc.sell.service;


import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    /**
     * 买家端方法
     */

    /** 创建订单 先用 DTO对象 到时候 用用到的时候再转换 */
    OrderDTO create(OrderDTO orderDTO);

    /** 查找单个订单 */
    OrderDTO findOne(String orderId);

    /** 查找订单列表 根据某用户的微信id */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单 */
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);


    /**
     * 卖家端方法
     */


    /** 查找所有订单列表  */
    Page<OrderDTO> findList(Pageable pageable);
}
