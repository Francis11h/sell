package com.imooc.sell.ObjectClassDemo;

/**
 * public class Object {
 * 	//先有个private的native方法 来注册下表示可以调用其他的native方法
 * 	private static native void registerNatives();
 * 	static {
 * 	    registerNatives();
 *        }
 * 	// Returns the runtime class of this {@code Object}
 * 	// 返回当前运行时对象的Class对象
 * 	1. public final native Class<?> getClass();
 * 	// 该方法返回对象的哈希码
 * 	// 如果2个对象使用equals方法进行比较并且相同的话，那么这2个对象的hashCode方法的值也必须相等。
 * 	2. public native int hashCode();
 * 	// 比较两个对象是否相等。Object类的默认实现，即比较2个对象的内存地址是否相等 即与 == 一样
 * 	// 注意点：如果重写了equals方法，通常有必要重写hashCode方法，这点已经在hashCode方法中说明了。 String类中 两者都重写Override了
 * 	3. public boolean equals(Object obj) { return (this == obj); }
 *     // 创建并返回当前对象的一份拷贝
 *     // 对于任何对象 x，表达式 x.clone() != x 为true，x.clone().getClass() == x.getClass() 也为true。
 *     4. protected native Object clone() throws CloneNotSupportedException;
 *     // toString方法  Object对象的默认实现，即 输出类的名字@实例的哈希码的16进制
 *     5. public String toString() { return getClass().getName() + "@" + Integer.toHexString(hashCode()); }
 *     // Wakes up a single thread that is waiting on this object's monitor.
 *     // 唤醒一个在此对象监视器上等待的线程(监视器相当于就是锁的概念)
 *     6. public final native void notify();
 *     // 跟notify一样，唯一的区别就是会唤醒在此对象监视器上等待的所有线程，而不是一个线程
 *     7. public final native void notifyAll();
 *     // wait方法会让当前线程等待直到另外一个线程调用对象的notify或notifyAll方法，或者超过参数设置的timeout超时时间。
 *     8. public final native void wait(long timeout) throws InterruptedException;
 *     // 多了一个nanos参数，这个参数表示额外时间（以毫微秒为单位，范围是 0-999999）
 *     9. public final void wait(long timeout, int nanos) throws InterruptedException {....}
 *     // 跟之前的2个wait方法一样，只不过该方法一直等待，没有超时时间这个概念。
 *     10. public final void wait() throws InterruptedException { wait(0); }
 *     // Object类的默认实现是不进行任何操作
 *     // 该方法的作用是实例被垃圾回收器回收的时候触发的操作，就好比 “死前的最后一波挣扎”。
 *     11. protected void finalize() throws Throwable { }
 * }
 */
public class ObjectClassDemo {
    public static void main(String[] args) {
        String str = "abc";
        Number n = 0;
        System.out.println(str.getClass());
        System.out.println(n.getClass());
    }
}
