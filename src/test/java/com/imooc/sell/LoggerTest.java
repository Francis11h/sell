package com.imooc.sell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class LoggerTest {

    @Test
    public void test1() {

        //日志中输出变量
        String name = "variable";
        String password = "123456";
        // {} 是占位符
        log.info("name : {}, password : {}", name, password);

        log.debug("debug.....");
        log.info("info....");
        log.error("error...");
    }
}
