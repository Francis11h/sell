package com.imooc.sell.volatileTest;


/**
 * 验证 volatile 不保证原子性
 * 原子性 指的是： 这里基本类似于 mysql 事务的原子性
 *  即不可分割，完整性， 某个线程正在做某个具体业务的时候 中间不能被加塞儿 或 分割 需要 整体完整
 *  要么同时成功 要么同时失败
 *
 *  本demo 演示 不保证原子性
 */


/**
 *  class MyData {
 *     volatile int number = 0;
 *     public void addTo60() {
 *         this.number = 60;
 *     }
 *     //此时 number前面 是加了 volatile 修饰的 non-atomic 不保证原子性
 *     public void addPlusPlus() {
 *         this.number++;
 *     }
 *  }
 *
 *  如果 20个 线程 每个线程 加一 1000次 那number最后应该是 200000,
 */

public class VolatileNotAtomic {

    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i))  .start();
        }

        // 等 上面20个 线程完成后 在用 main 线程 取得最后的结果值看看是多少
        // 为什么 大于2 因为 后台默认有两个 线程 一个是 main线程 一个是 gc 线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);
    }
}


//结果 每次都不一样 所以 原子性 并不被保证