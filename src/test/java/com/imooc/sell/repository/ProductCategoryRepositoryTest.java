package com.imooc.sell.repository;

import com.imooc.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 单元测试 用 @RunWith
 */

@RunWith(SpringRunner.class)
@SpringBootTest()

public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    //search
    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategory =  repository.findById(1);
        //ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    //insert
    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生喜爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    //update
    @Test
    public void updateTest() {
        ProductCategory productCategory = repository.findById(2).get();
        productCategory.setCategoryType(4);
        repository.save(productCategory);
    }

    //update
    @Test
    @Transactional          //这个是为了保持数据库的干净 这里插入的 会完全回滚
    public void saveTest2() {
        ProductCategory productCategory = new ProductCategory("大学生最爱", 5);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null, result);
    }


    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}