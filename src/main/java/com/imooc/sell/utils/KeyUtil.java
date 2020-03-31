package com.imooc.sell.utils;

import java.util.Random;

/**数据库中 约束 索引 都叫key 所以我们这个就是 keyUtil*/

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式 : 时间 + 随机数
     * @return
     *
     */

    /** 即使精确到毫秒 6位还是 可能会有重复 所以 限制多线程 加 synchronized关键字 */

    public static synchronized String genUniqueKey() {

        Random random = new Random();

        /**
         * System.currentTimeMillis();
         * Returns the current value of the running Java Virtual Machine's high-resolution time source
         */

        //我们希望生成的随机数的位数是相同的 所以处理下 比如都是6位数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
