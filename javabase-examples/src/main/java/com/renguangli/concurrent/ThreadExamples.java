package com.renguangli.concurrent;

/**
 * ThreadExamples
 *
 * @author renguangli 2018/11/2 10:25
 * @since JDK 1.8
 */
public class ThreadExamples {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.err.println("a"));
        thread.start();
        // thread.start(); 多次 start 会抛出 IllegalThreadStateException


    }
}
