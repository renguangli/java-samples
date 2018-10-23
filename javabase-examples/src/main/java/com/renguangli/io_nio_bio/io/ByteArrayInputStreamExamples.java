package com.renguangli.io_nio_bio.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * ByteArrayInputStreamExamples
 *
 * @author renguangli 2018/10/22 17:08
 * @since JDK 1.8
 */
public class ByteArrayInputStreamExamples {

    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        InputStream is = new ByteArrayInputStream(bytes);


    }
}
