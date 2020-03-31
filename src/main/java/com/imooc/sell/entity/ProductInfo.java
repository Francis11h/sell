package com.imooc.sell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    /**小图地址*/
    private String productIcon;

    /**状态 0正常 1下架
     *  默认为在架的状态 这样子 new 的时候 就已经有值了 否则 这个 到后面传的时候 是 null
     */

    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**类目编号*/
    private Integer categoryType;


    private Date createTime;

    private Date updateTime;

    //查商品状态的方法
    //该注解 在对象转JSON时忽略 因为我们不需要json传这些字段
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}



























