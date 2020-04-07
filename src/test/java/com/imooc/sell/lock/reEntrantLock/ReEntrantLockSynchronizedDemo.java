package com.imooc.sell.lock.reEntrantLock;

/**
 * synchronized 可重入锁
 */
class Phone {   //资源类

    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t ######## invoked sendEmail()");
    }

}

/**
 * 指的是 同一函数 外层函数 获得锁之后 内层函数仍能够获取该锁的代码
 * 即 同一个线程 在外层方法获取锁之后, 再进入内层会自动获取锁
 * 即 线程可以进入 任何一个它已经拥有的锁 所同步着的 代码块儿
 *
 * 一句话: 大白话 你家门口一把大锁就够了 开了大门的锁 相当于可以进 卧室 进卫生间
 *
 * t1	 invoked sendSMS()                      t1 线程在外层方法获取锁的时候
 * t1	 ######## invoked sendEmail()           t1 进入内层方法会自动获取锁
 *
 */
public class ReEntrantLockSynchronizedDemo {


    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }

}
