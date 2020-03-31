package com.imooc.sell.service;

import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    /** 根据productId 查找一个商品 返回其表的一个实体 */
    // 接口中所有的 方法都是抽象的
    public abstract ProductInfo findOne(String productId);

    /** 查找在架的商品 */
    List<ProductInfo> findUpAll();

    /** 管理端 查找全部商品  同时需要分页 选springframework 里的 Pageable 返回一个Page对象*/
    Page<ProductInfo> findAll(Pageable pageable);

    /** save 方法 */
    ProductInfo save(ProductInfo productInfo);

    /** 加库存  取消订单的时候  传的是一个List 每个元素是购物车中的一条  */
    void increaseStock(List<CartDTO> cartDTOList);

    /** 减库存 下订单的时候*/
    void decreaseStock(List<CartDTO> cartDTOList);

    /** 上架*/
    ProductInfo onSale(String productId);

    /** 下架*/
    ProductInfo offSale(String productId);

}
