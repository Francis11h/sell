package com.imooc.sell.repository;

import com.imooc.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**主键是 String 类型*/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**查询上架商品*/
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
