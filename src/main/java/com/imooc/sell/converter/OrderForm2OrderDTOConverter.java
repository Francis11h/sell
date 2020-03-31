package com.imooc.sell.converter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.entity.OrderDetail;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
/** orderForm 转换为 orderDTO 的转换器 */
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        /**
         * 为什么 不用 BeanUtils.copyProperties(orderForm, orderDTO);
         *  因为 OrderForm 中 名字字段名称为 name , orderDTO 中 名字字段名称为 buyerName
         *  字段名称不一样 不可以直接转换
         */
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        /** 第一个参数是 String 第二个参数是要转换成的 type（class） 我们这里是 要转换成list */
        /** 转换可能会出错 所以try catch下*/

        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
                    /** 第二个参数是 把 List<OrderDetail> 的类型取出来 通过TypeToken*/
        } catch (Exception e) {
            log.error("【对象转换】错误, string = {}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        //要的是一个list 但传进来的是字符 但是是 JSON格式的 所以我们用下 json转换
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}



















