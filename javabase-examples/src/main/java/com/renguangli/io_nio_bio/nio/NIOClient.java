package com.renguangli.io_nio_bio.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * NIOClient
 *
 * @author renguangli 2018/10/18 13:54
 * @since JDK 1.8
 */
public class NIOClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            Socket socket = new Socket("127.0.0.1", 8080);
            OutputStream out = socket.getOutputStream();
            String s = "hello world";
            out.write(s.getBytes());
            out.close();
            Thread.sleep(2000);
        }

    }

}
