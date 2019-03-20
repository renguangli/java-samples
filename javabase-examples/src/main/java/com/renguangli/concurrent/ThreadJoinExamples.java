package com.renguangli.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * javabase-examples
 * Created by renguangli at 2019/1/18 16:37
 *
 * @since JDK1.8
 */
public class ThreadJoinExamples {


    // 如果当前线程需要另一个线程结果这时候需要 join 方法
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Thread t = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                integers.add(j);
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integers);
    }
}
