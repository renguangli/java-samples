package com.renguangli.kafka;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ComplateFutureSamples {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> sss = CompletableFuture.runAsync(() -> {
            try {
                action("sss");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        sss.thenRun(() -> System.out.println(1));
        sss.thenRun(() -> System.out.println(2));
        sss.thenRun(() -> System.out.println(3));
        sss.thenRun(() -> System.out.println(4));


        sss.get();
    }
    public static void action(String a) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(a);

    }
}
