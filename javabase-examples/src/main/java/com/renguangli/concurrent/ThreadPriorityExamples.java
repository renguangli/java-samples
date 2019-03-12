package com.renguangli.concurrent;

/**
 * ThreadPriorityExamples
 * Created by renguangli at 2018/12/24 14:13
 *
 * @since JDK1.8
 */
public class ThreadPriorityExamples {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello thread");
        });
        thread.setName("priority-thread");
        thread.setPriority(1); // 线程优先级最小1，最大10，默认5
        thread.start();
    }
}
