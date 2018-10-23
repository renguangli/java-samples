package com.renguangli.io_nio_bio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServerExamples implements Runnable {

    Selector selector;

    public NIOServerExamples(int port) throws IOException {
        // 0.开启selector监听器
        selector = Selector.open();
        // 1.开启通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 2.通道监听端口
        ssc.bind(new InetSocketAddress(port));
        // 3.设置通道属性(非阻塞)
        ssc.configureBlocking(Boolean.FALSE);
        // 4.注册到selector选择器
        ssc.register(selector, SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 1.开始监听
                selector.select();
                // 2.获取多路复用器选择的结果集
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    if (key.isValid() && key.isAcceptable()) {
                        doAccept(key);
                    }
                    if (key.isValid() && key.isReadable()) {
                        doRead(key);
                    }
                    if (key.isValid() && key.isWritable()) {
                        doWrite(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doAccept(SelectionKey key) {
        try {
            SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
            sc.configureBlocking(Boolean.FALSE);
            sc.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            System.out.println("accept 异常");
            e.printStackTrace();
        }
    }

    private void doRead(SelectionKey key) {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer reqBuffer = ByteBuffer.allocate(2048);

        try {
            int i = sc.read(reqBuffer);
            if (i >= 0) {
                reqBuffer.flip();
                byte[] bytes = new byte[reqBuffer.remaining()];
                reqBuffer.get(bytes);
                System.out.println(new String(bytes));
                key.attach("res");
                key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            } else {
                sc.close();
            }
        } catch (IOException e) {
            System.out.println("read 异常");
            try {
                sc.close();
                sc.socket().close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void doWrite(SelectionKey key) {
        SocketChannel sc = (SocketChannel) key.channel();
        String handle = (String) key.attachment();// 取出read方法传递的信息。
        ByteBuffer retBuffer = ByteBuffer.wrap(handle.getBytes());

        try {
            sc.write(retBuffer);
            sc.close();
        } catch (IOException e) {
            System.out.println("write 异常");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("正在启动服务...");
        new Thread(new NIOServerExamples(8000)).start();
    }

}
