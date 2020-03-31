package com.imooc.sell.controller;


import com.imooc.sell.entity.ProductCategory;
import com.imooc.sell.entity.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultVOUtil;
import com.imooc.sell.viewobject.ProductInfoVO;
import com.imooc.sell.viewobject.ProductVO;
import com.imooc.sell.viewobject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController             //返回的是JSON格式
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "123")  //缓存  第二次访问不会走这个方法 而是直接从redis里面读取
    public ResultVO list() {

        /**1. DB查询所有的上架 的商品   存入 productInfoList */
        List<ProductInfo> productInfoList = productService.findUpAll();
        /**2. DB查询类目（一次性查询 即先查出来,  千万不要把DB查询写到步骤三的for循环里） 存入 productCategoryList */

//        List<Integer> categoryTypeList = new ArrayList<>();
//        //传统方法取categoryList
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        //精简的方法（java8 lambda表达式）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        /** 3. 数据拼装  拼 ResultVO*/

        /** 3.1  拼  ResultVO.data[] 用 productVOList 命名  */
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            /** 3.2  找出所有类目 一个类目是一个 ProductVO */
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            /** 3.3  拼类目里面的 foods[]  用 productInfoVOList 命名 */
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                /** 3.4  foods[]里面的 上架商品属于该类目的时候 该 productInfoVOList 加一个 productInfoVO */
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //数据拷贝 source to destination  否则每个相同字段都要写一个 copy
                    // id 拷贝 productInfoVO.setProductId(productInfo.getProductId()); 名称拷贝 各种 很麻烦
                    // spring 自带的类 BeanUtils 就很舒服
                    BeanUtils.copyProperties(productInfo, productInfoVO);

                    productInfoVOList.add(productInfoVO);            // foods[] 加 productInfoVO
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);                           // data[] 加 productVO
        }

//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);
        /** 封装到 ResultVOUtil类中了 */
        return ResultVOUtil.success(productVOList);
    }
}
