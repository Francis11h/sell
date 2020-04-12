package com.imooc.sell.deadLockDemo;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有: " + lockA + "\t 尝试获得: " + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有: " + lockB + "\t 尝试获得: " + lockA);
            }
        }
    }
}

/**
 * 死锁是 两个或两个以上线程 执行中 因争夺资源 导致的一种互相等待的现象
 * 即 线程持有自己的锁 还妄图得到别人的锁
 *      两个线程 都这样儿  吃着碗里的看着锅里的
 */

public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();
    }

}


/**
 怎么解决？

 1.  jps -l 命令 查看当前进程的进程号
 (linux 里 ps -ef|grep XXX    ls -l)
 (jps = java ps)
 2.  jstack + 该进程号 找死锁查看
 */