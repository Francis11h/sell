package com.imooc.sell.lock.reEntrantLock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyTest implements Runnable {

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        inner();
    }

    public void inner() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked inner()");
            ininner();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void ininner() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ##### invoked ininner()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ReEntrantLockClassDemo {
    public static void main(String[] args) {
        MyTest test = new MyTest();

        Thread t1 = new Thread(test, "t1");
        Thread t2 = new Thread(test, "t2");
        t1.start();
        t2.start();
    }
}
