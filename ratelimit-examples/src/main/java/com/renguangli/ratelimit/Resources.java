package com.renguangli.ratelimit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * java-utils
 * Created by renguangli at 2018/12/12 19:02
 * @since JDK1.8
 */
public final class Resources {

    public static InputStream getResourceAsStream(String resource) throws IOException {
        return getResourceAsStream(getClassLoader(), resource);
    }

    public static InputStream getResourceAsStream(ClassLoader classLoader, String resource) throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(resource);
        if (inputStream == null) {
            throw new IOException("Could not find resource " + resource);
        }
        return inputStream;
    }

    public static Properties getResourceAsProperties(String resource) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = getResourceAsStream(resource);
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    public static String getResourceAsString(String resource) throws IOException {
        InputStream is = getResourceAsStream(resource);
        int length = 0;
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while ((length = is.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, length));
            bytes = new byte[bytes.length * 2];
        }
        return sb.toString();
    }

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

}
