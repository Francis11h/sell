package com.imooc.sell.repository;

import com.imooc.sell.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**主键是 String 类型*/
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    /**查询人员信息 通过openid*/
    SellerInfo findByOpenid(String openid);
}
