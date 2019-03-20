package com.renguangli.concurrent;

/**
 * javabase-examples
 * Created by renguangli at 2019/1/16 11:16
 *
 * @since JDK1.8
 */
public class ThreadInterupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread1();
        t1.start();
    }

}

class MyThread1 extends Thread {

    @Override
    public void run() {
        System.out.println(isInterrupted());//
        this.interrupt();
        System.out.println(isInterrupted());
        System.out.println(interrupted());
        System.out.println(isInterrupted());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(isInterrupted());
    }
}