package com.imooc.sell.constant;

/**
 * redis 常量
 */
public interface RedisConstant {

    /** 以 token_ 开头*/
    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200;  // 2 小时

}
