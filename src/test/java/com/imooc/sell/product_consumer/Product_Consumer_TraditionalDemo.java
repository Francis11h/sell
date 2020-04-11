package com.imooc.sell.product_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 题目 一个初始值为0的变量 两个线程对其交替操作 一个加1一个减1 来5轮
 *  加一减一  一看就是 生产者消费者模式
 *
 *  多线程的企业级模版口诀
 *      1。 高内聚低耦合的情况下 线程 操纵 资源类
 *      2。 判断 干活 唤醒通知
 *      3。 严防多线程并发状态下的 虚假唤醒  多线程的判断一定用while 不是 if 官方Object类种说了wait方法必须用在loop中
 *
 *   synchronized 被 lock      替代
 *   wait         被 await     替代
 *   notify       被 signal    替代
 */

//资源类 尽量解耦
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            // 1 判断
            while (number != 0) {
                //等待 不生产
                //等待 需要用condition
                condition.await();
            }
            // 2 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t "+ number);
            // 3 通知唤醒
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            // 1 判断
            while (number == 0) {
                //等待 不生产
                //等待 需要用condition
                condition.await();
            }
            // 2 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t "+ number);
            // 3 通知唤醒
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Product_Consumer_TraditionalDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BBB").start();
    }
}


