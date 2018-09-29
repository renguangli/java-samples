package com.renguangli.concurrent;

/**
 * ConcurrencyTest
 *
 * @author renguangli 2018/9/12 10:03
 * @since JDK 1.8
 */
public class ConcurrencyTest {

    private static final int count = 1;

    public static void main(String[] args) throws InterruptedException {
        concurrent();
    }

    private static void concurrent() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (int i = 0; i < count; i++) {
                a += 5;
            }
            System.err.println(a);
        });
        thread.start();
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        System.err.println(b);
        thread.join();

        System.out.println(System.currentTimeMillis() - start);
    }
}
