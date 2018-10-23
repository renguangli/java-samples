package com.renguangli.io_nio_bio.io;

import com.renguangli.io_nio_bio.IOUtils;
import com.renguangli.io_nio_bio.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * IOServerExamples
 *
 * @author renguangli 2018/10/19 9:54
 * @since JDK 1.8
 */
public class IOServerExamples {

    public static void main(String[] args) {
        try {
            new IOServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class IOServer {

    // 负责处理请求的线程池
    private ExecutorService worker;

    private ServerSocket serverSocket;

    public IOServer() throws IOException {
        this.worker = Executors.newFixedThreadPool(Server.nThreads);
        this.serverSocket = new ServerSocket(Server.PORT);
        System.out.println("the server is running, port is " + Server.PORT);
        this.doAccept();
    }

    private void doAccept() throws IOException {
        while (true) {
            Socket client = serverSocket.accept();
            this.worker.execute(() -> this.doRequest(client));
        }
    }

    private void doRequest(Socket client) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = client.getInputStream();
            os = client.getOutputStream();
            String inputMessage = IOUtils.read(is);
            System.out.println(inputMessage);
         /*   while (true) {
                String inputMessage = IOUtils.read(is);
                if (!"".equals(inputMessage)) {
                    System.out.println(inputMessage);
                    os.write(inputMessage.getBytes());
                    os.flush();
                    break;
                }
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(is, os);
            IOUtils.closeSocket(client);
        }
    }

}
