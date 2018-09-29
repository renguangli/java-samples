package com.renguangli.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * IOServer
 *
 * @author renguangli 2018/9/26 11:56
 * @since JDK 1.8
 */
public class IOServer {

    private static ExecutorService boss = Executors.newFixedThreadPool(10);

    private static ExecutorService worker = Executors.newFixedThreadPool(10);

    private static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        accept();
    }

    private static void accept() {
        boss.submit(() -> {
            while (true) {
                Socket socket = serverSocket.accept();
                worker.submit(() -> doRequest(socket));
            }
        });
    }

    private static void doRequest(Socket socket) {
        try {
            InputStream input = socket.getInputStream();
            int length;
            byte[] bytes = new byte[1024];
            while ((length = input.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, length));
            }
            OutputStream out = socket.getOutputStream();
            out.write("hello,world".getBytes());
            input.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
