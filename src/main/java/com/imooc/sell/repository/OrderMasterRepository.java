package com.imooc.sell.repository;


import com.imooc.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**主键是 String 类型*/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /** 按照买家openid 来查 并且有一个分页 */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
