package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;


public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        //吧 message里面的内容传到父类的构造方法里面去   会把错误的信息打印出来
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
