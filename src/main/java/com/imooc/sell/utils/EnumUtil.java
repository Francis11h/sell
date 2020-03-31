package com.imooc.sell.utils;

import com.imooc.sell.enums.CodeEnum;

/**
 * 枚举的工具类
 *
 */

public class EnumUtil {

    //返回一个枚举类  用范型来表示 T 继承自 CodeEnum 这个枚举
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
