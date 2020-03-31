package com.imooc.sell.repository;

import com.imooc.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**主键是 String 类型*/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    /** 按照orderId查 master表中一条orderId 可以在detail表中查到多条  */
    List<OrderDetail> findByOrderId(String orderId);

}
