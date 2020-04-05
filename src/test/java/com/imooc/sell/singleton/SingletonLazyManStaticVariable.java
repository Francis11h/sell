package com.imooc.sell.singleton;


class Singleton3 {
    private Singleton3() {};
    private static Singleton3 instance;

    //提供一个 静态方法 当使用到该方法时采取创建 instance 即懒汉式
    public static Singleton3 getInstance() {
        if (instance == null) { //等于null代表还没创建 此时才去创建它
            instance = new Singleton3();
        }
        return instance;
    }
}

public class SingletonLazyManStaticVariable {

    public static void main(String[] args) {
        System.out.println("懒汉式");
        Singleton3 instance1 = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        //判定是否相同 双等号 == 比的是 内存地址
        System.out.println(instance1 == instance2);
        System.out.println("instance1.hashCode = " + instance1.hashCode());
        System.out.println("instance2.hashCode = " + instance2.hashCode());
    }
}
