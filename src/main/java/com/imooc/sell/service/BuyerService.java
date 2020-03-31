package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 买家 用来验证 是不是本人操作 即 传入的openid 和 DB里对应订单的openid 是否一致
 */
public interface BuyerService {

    /** 查询一个订单*/
    OrderDTO findOrderOne(String openid, String orderId);

    /** 取消订单 */
    OrderDTO cancelOrder(String openid, String orderId);
}
