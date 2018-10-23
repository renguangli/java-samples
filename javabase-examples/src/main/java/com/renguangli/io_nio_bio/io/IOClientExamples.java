package com.renguangli.io_nio_bio.io;

import com.renguangli.io_nio_bio.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * IOClientExamples
 *
 * @author renguangli 2018/10/19 12:26
 * @since JDK 1.8
 */
public class IOClientExamples {
    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try (IOClient client = new IOClient()) {
                    client.request();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}

class IOClient implements AutoCloseable{

    private Socket client;

    private OutputStream os;

    public IOClient() throws IOException {
        this.client = new Socket(Server.HOST, Server.PORT);
        this.os = client.getOutputStream();
    }

    public void request() throws IOException {
        os.write("hello world".getBytes());
        os.flush();
    }

    @Override
    public void close() throws Exception {
        os.close();
        client.close();
    }

}