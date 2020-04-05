package com.imooc.sell.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  CAS 是什么 --> 比较并交换 compare and set
 *  都先拿 只有比较一致的情况下 才能 set
 */


public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        // main done something
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 6) + "\t current data: " + atomicInteger.get());
    }
}
