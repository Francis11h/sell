package com.imooc.sell.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool2 = Executors.newSingleThreadExecutor()
//        ExecutorService threadPool3 = Executors.newCachedThreadPool()		// 一池可变数线程

        //  模拟 10个用户来办理业务 每来一个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        // 计算机专业 看电脑 有几个核儿...
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
