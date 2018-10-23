package com.renguangli.io_nio_bio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIOServer
 *
 * @author renguangli 2018/10/18 13:33
 * @since JDK 1.8
 */
public class NIOServer {

    private Selector selector;

    public void start() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8080));

        selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();// 轮询 io 事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (!key.isValid()) { // 如果事件无效处理下一个事件
                    it.remove();
                    continue;
                }

                this.doEvent(key); // 处理事件

                it.remove(); // 将处理了的事件移除
            }
        }
    }

    private void doEvent(SelectionKey key) {
        if (key.isAcceptable()) {
            accept(key);
        } else if (key.isReadable()) {
            channelRead(key);
        } else if (key.isWritable()) {
            channelWrite(key);
        }
    }

    private void accept(SelectionKey key) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(Boolean.FALSE);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void channelRead(SelectionKey key) {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            StringBuilder sb = new StringBuilder();
            while (socketChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                sb.append(new String(byteBuffer.array()));
                byteBuffer.clear();
            }
            System.out.println(sb.toString());
            key.attach(sb.toString());
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketChannel.close();
                socketChannel.socket().close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void channelWrite(SelectionKey key) {
        String handle = (String) key.attachment(); // 取出read方法传递的信息。
        ByteBuffer retBuffer = ByteBuffer.wrap(handle.getBytes());
        try (SocketChannel socketChannel = (SocketChannel) key.channel()){
            socketChannel.write(retBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new NIOServer().start();
    }

}
