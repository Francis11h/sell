package com.imooc.sell.repository;

import com.imooc.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**主键是 Integer 类型*/
//JpaRepository<ProductCategoryRepository, Integer> 对象是ProductCategory 主键是 Integer类型的
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
