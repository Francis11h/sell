package com.imooc.sell.service;

import com.imooc.sell.entity.SellerInfo;

public interface SellerService {
    /**
     * 通过openid来查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
