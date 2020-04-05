package com.imooc.sell.singleton;


class Singleton {
    private Singleton(){};
    private final static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}

//static 代码块儿
class Singleton2 {
    private Singleton2(){

    };
    static {    //在静态代码块儿中创建单例对象
        instance = new Singleton2();
    }
    private static Singleton2 instance;

    public static Singleton2 getInstance() {
        return instance;
    }
}

public class SingletonHungerManStaticVariable {
    public static void main(String[] args) {

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        //判定是否相同 双等号 == 比的是 内存地址
        System.out.println(instance1 == instance2);
        System.out.println("instance1.hashCode = " + instance1.hashCode());
        System.out.println("instance2.hashCode = " + instance2.hashCode());
    }
}
