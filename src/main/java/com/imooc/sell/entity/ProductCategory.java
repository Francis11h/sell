package com.imooc.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


//命名方式把下划线改成驼峰
//否则要加 如果数据库表名为s_product_category
//这前头要加上 @Table(name = "s_product_category")

/**
* 这是商品类目表的实体类
*/


@Entity                           // 数据库表 映射成对象 加 @Entity 注解
@DynamicUpdate                   // 自动更新创建插入时间
@Data                           // 包含了生成 get set toString 各种方法
public class ProductCategory {

    /**类目id**/
    @Id                 //主键注解
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //自增类型  括号里是为了后面插入不报错
    private Integer categoryId;

    /**类目名字**/
    private String categoryName;

    /**类目编号**/
    private Integer categoryType;

    private Date createTime;
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
