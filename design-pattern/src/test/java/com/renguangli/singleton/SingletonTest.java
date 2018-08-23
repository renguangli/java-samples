package com.renguangli.singleton;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * SingletonTest
 *
 * @author renguangli 2018/7/25 10:50
 * @since JDK 1.8
 */
public class SingletonTest {

    @Test
    public void singleton() {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                    System.err.println(Singleton.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.countDown();

        try {
            Thread.sleep(2000);
            //System.out.println(Singleton.count.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}