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
        while (!isInterrupted()) {
            // 返回线程中断标志 true | false
            System.out.println(isInterrupted());
            this.interrupt(); // 将当前中断标志设置为 true
            // System.out.println(Thread.interrupted()); // 返回中断标志，并清除中断标志，设置为 false
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }

}