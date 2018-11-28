package com.renguangli.exception;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Throwable Error Exception
 *
 * @author renguangli 2018/10/30 19:25
 * @since JDK 1.8
 */
public class ExceptionExamples {

    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("D:/a.txt");){
            os.write("hello world".getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryCatch() {

    }

    public void throwsThrow(String str) throws Exception{
        if (str == null) {
            throw new Exception("parameter str not be null");
        }
    }
}
