package com.imooc.sell.blockingQueueDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *  阻塞队列
 *
 *  2.1
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // List list = new ArrayList();
        // 队列只有三个位置
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

//        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("b", 2, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("c", 2, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("d", 2, TimeUnit.SECONDS));
        BlockingQueue<String> bq = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put a");
                bq.put("a");
                System.out.println(Thread.currentThread().getName() + "\t put b");
                bq.put("b");
                System.out.println(Thread.currentThread().getName() + "\t put c");
                bq.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t " + bq.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t " + bq.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t " + bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();

    }

}
