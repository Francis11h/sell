package com.imooc.sell.semaphoreDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3); // 模拟3个停车位

        for (int i = 1; i <= 6; i++) {      //模拟6部汽车
            new Thread(() -> {
                try {
                    // 一部车 占到一个车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    // 停一会儿
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }

    }
}
