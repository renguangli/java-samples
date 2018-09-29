package com.renguangli.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * IOClient
 *
 * @author renguangli 2018/9/26 13:12
 * @since JDK 1.8
 */
public class IOClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 8080);
        for (;;) {
            OutputStream out = socket.getOutputStream();
            out.write("hello,world".getBytes());
            out.flush();
            InputStream input = socket.getInputStream();
            int read;
            while ((read = input.read()) != -1) {
                System.out.println((char)read);
            }

            Thread.sleep(2000);
        }
    }
}
