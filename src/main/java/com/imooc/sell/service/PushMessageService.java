package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import org.hibernate.criterion.Order;

/**
 * 推送消息
 */

public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}






















