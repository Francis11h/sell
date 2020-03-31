package com.imooc.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 */

@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    /**小图地址*/
    private String productIcon;

    //有单独的操作 不需要这个
//    /**状态 0正常 1下架*/
//    private Integer productStatus;

    /**类目编号*/
    private Integer categoryType;
}
