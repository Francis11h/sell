package com.imooc.sell.singleton.DCL;


import com.imooc.sell.singleton.SingletonDemo;

class Singleton{
    private Singleton() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法Singleton()");
    };
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class DCL {
    public static void main(String[] args) {

        for (int i = 1; i <= 20; i++) {
            new Thread(Singleton::getInstance, String.valueOf(i)).start();
        }
    }
}
