package com.imooc.sell.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{


        //closeDoor();    //班长最后锁门的 例子
    }

    // option + command + enter  = extract method
    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        // 6个 同学 上完自习 离开教室
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习, 离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        // main 线程
        System.out.println(Thread.currentThread().getName() + "\t********班长最后关门走人");
    }
}
