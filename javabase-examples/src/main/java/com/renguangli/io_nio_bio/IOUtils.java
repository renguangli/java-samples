package com.renguangli.io_nio_bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * IOUtils
 *
 * @author renguangli 2018/10/19 12:30
 * @since JDK 1.8
 */
public final class IOUtils {

    private IOUtils(){}

    public static String read(InputStream is) throws IOException {
        int len;
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while ((len = is.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len));
        }
        return sb.toString().trim();
    }

    public static void closeStream(InputStream is, OutputStream os) {
        try {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void closeSocket(Socket socket) {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
