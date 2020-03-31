package com.imooc.sell.service.impl;

import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.entity.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**  这个注解也不能省 代表是 service */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        /** 用 枚举 防止记不清 0或1 到底代表什么 */
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        /** 返回的是一个 Page对象 */
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            /** 商品不存在抛异常 */
            if (!repository.findById(cartDTO.getProductId()).isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    /** 它是一个集合 要么全部成功 要么全部不成功 所以要加个事务   逻辑很简单 看库存够不够 够的话就减掉 */
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            /** 先查 */
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();

            /** 改了 商品不存在抛异常*/
            if (!repository.findById(cartDTO.getProductId()).isPresent()) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();

            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }



    @Override
    public ProductInfo onSale(String productId) {

        if (!repository.findById(productId).isPresent()) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        } else {
            ProductInfo productInfo = repository.findById(productId).get();
            if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
                throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
            }
            //更新
            productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
            return repository.save(productInfo);
        }
    }



    @Override
    public ProductInfo offSale(String productId) {
        if (!repository.findById(productId).isPresent()) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        } else {
            ProductInfo productInfo = repository.findById(productId).get();
            if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
                throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
            }
            //更新
            productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
            return repository.save(productInfo);
        }
    }
}













