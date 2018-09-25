package com.renguangli.thread;

/**
 * ThreadExamples
 *
 * @author renguangli 2018/8/21 18:17
 * @since JDK 1.8
 */
public class ThreadExamples {

    private static ThreadExamples examples = new ThreadExamples();

    public static void main(String[] args) {
        examples.createThread();
    }

    public void createThread() {
        new Thread(() -> {
            while (true) {

            }
        }).start();
    }

}
