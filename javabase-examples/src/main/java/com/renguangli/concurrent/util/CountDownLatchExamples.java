package com.renguangli.concurrent.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
 * CountDownLatch 等待一个线程执行完
 * Created by renguangli at 2018/10/21 15:13
 * @since JDK1.8
 */
public class CountDownLatchExamples {

    private int nThreads = 1000;

    private CountDownLatch latch = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(nThreads);

    public void waitOtherThreads() {
        new Thread(() -> {
            System.err.println("thread :" + Thread.currentThread().getName() + " 正在运行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 计数器减 1
            latch.countDown();
        }).start();

        try {
//            latch.await();
//            System.out.println("其他线程已结束运行");
            latch.await(1000L, TimeUnit.MILLISECONDS);
            System.out.println("其他线程 1000 毫秒内未完成运行，提前结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟并发
     */
    private int count = 0;
    public void concurrent() {
        for (int i = 0; i < nThreads; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                    synchronized (this) {
                        ++ count;
                    }
                    latch2.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.countDown();
        try {
            latch2.await();
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

