package com.renguangli.nio.selector;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * SelectorExamples
 *
 * @author renguangli 2018/8/17 17:47
 * @since JDK 1.8
 */
public class SelectorExamples {

    public static void main(String[] args) throws InterruptedException {
        try {
            Selector selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Runnable runnable = new Runnable() {
            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        thread.start();

    }
}
