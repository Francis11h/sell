package com.imooc.sell.volatileTest;


/**
 * 验证Volatile的可见性
 * 1.1 假设number变量为0 之前number 变量没有添加 volatile修饰 没有可见性 main 线程会一直等待
 * 1.2 volatile 可保证可见性 及时通知其他线程 主物理内存的值已经被修改
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();   //线程操纵资源类

//        new Thread(() -> {
//
//        }, "AAA").start();
        // 如果不在外头包一个 new Thread().start() 则不会新建新的线程 相当于还是 主main线程 不信可以实验 但是这个是 用接口创建 直接extends Thread 就可以直接启
        new Thread(new MyThread(myData), "AAA").start();


        while (myData.number == 0) {
            // main 进程一直等待循环 直到number的值不再等于0
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }

}
