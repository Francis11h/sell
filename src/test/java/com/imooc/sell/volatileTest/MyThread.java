package com.imooc.sell.volatileTest;

class MyThread implements Runnable {
    public MyData mydata;

    public MyThread (MyData myData) {
        this.mydata = myData;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t come in");
        try {
            // 睡眠三秒
//            TimeUnit.SECONDS.sleep(3);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mydata.addTo60();
        System.out.println(Thread.currentThread().getName() + "\t update number value: " + mydata.number);
    }
}
