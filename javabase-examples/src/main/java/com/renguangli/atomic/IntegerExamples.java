package com.renguangli.atomic;

import java.util.concurrent.CountDownLatch;

/**
 * IntegerExamples
 *
 * @author renguangli 2018/9/10 17:51
 * @since JDK 1.8
 */
public class IntegerExamples {

    public static void main(String[] args) throws InterruptedException {
        final Integer[] i = {0};
//        AtomicInteger atomicInteger = new AtomicInteger();
        CountDownLatch latch = new CountDownLatch(1000);
        for (int j = 0; j < 1000; j++) {
            new Thread(() ->{
                latch.countDown();
                synchronized (IntegerExamples.class) {
                    i[0]++;
                }
//                atomicInteger.addAndGet(1);
            }).start();
        }
        latch.await();
        System.out.println(i[0]);
//        System.out.println(atomicInteger.intValue());

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.err.println(new Integer(10).hashCode());
    }
}
