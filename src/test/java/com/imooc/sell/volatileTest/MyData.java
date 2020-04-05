package com.imooc.sell.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    volatile int number = 0;
    void addTo60() {
        this.number = 60;
    }
    //此时 number前面 是加了 volatile 修饰的 non-atomic 不保证原子性
    void addPlusPlus() {
        this.number++;
    }

    // synchronized 保证 同一时刻 只能有一个 线程访问 该方法
    public synchronized void addPlusPlusSynchronized() {
        this.number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
