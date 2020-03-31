package com.imooc.sell.service;


import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

@Commit
@Slf4j
public class RedisLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     *  加锁
     * @param key   productId
     * @param value 当前时间 + 超时时间 时间戳格式
     * @return
     */
    public boolean lock (String key, String value) {
        // 如果可以成功设置 返回true 代表成功锁住 这里
        // setIfAbsent 等同于 SETNX 这个 redis 命令
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        // 加的这一串而 会避免死锁
        // 同时保证 多个线程进来 只有一个会拿到锁 因为 假设currentValue = A 两个线程的value都是B 其中一个走了getAndSet 会修改value 另一个拿到的oldValue就不会是A 而是B了
            String currentValue = redisTemplate.opsForValue().get(key);
            // 如果锁过期
            // 并且 存进去的时间 < 当前时间
            if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
                // 获取上一个锁的时间
                // getAndSet 等同于 redis中GETSET方法
                String oldValue = redisTemplate.opsForValue().getAndSet(key, value);

                if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                    return true;
                }
            }

        return false;
    }

    /**
     * 解锁 其实就是删掉key
     * @param key
     * @param value
     */

    public void unlock (String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("【redis分布式锁】 解锁异常");
        }
    }
}

































