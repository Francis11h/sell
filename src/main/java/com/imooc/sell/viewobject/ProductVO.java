package com.imooc.sell.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品 包含类目
 *
 */
@Data

public class ProductVO implements Serializable {

    private static final long serialVersionUID = -5596928748470416356L;

    /** 该注解转换 把 categoryName 转换为 name，写catrgoryName是为了清晰的知道到底是哪个的名字
     *  name 是因为 前端给的 JSON 规定 该字段名称为 name
     */
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    /** 与ProductInfo 相比字段要少 后台的一些数据不要返回 比如库存什么的 不安全 */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}















