package com.renguangli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * examples
 *
 * @author renguangli 2018/6/22 10:05
 * @since JDK 1.8
 */
public class HttpClient {

    /**
     *集团接口客户密钥
     */
    private static final String  CONSUMER_KEY ="us2PqSAHhmlovMVrkpaEpP2fOdEa";

    /**
     * 集团接口客户隐私
     */
    private static final String CONSUMER_SECRET="e06TRTWkFsfUoVEBvz1zhRb81JEa";

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://open.wodata.local/token");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();

        conn.setDoOutput(true);
        conn.setDoInput(true);

        conn.setRequestMethod("POST");
        String encode = encode(CONSUMER_KEY + ":" + CONSUMER_SECRET);
        conn.setRequestProperty("Authorization","Basic " + encode);

        OutputStream out = conn.getOutputStream();
        out.write("grant_type=client_credentials".getBytes());
        out.flush();

        InputStream input = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        input.close();
        out.close();
        System.err.println(sb.toString());
    }

    private static String encode(String auth) {
        return Base64.getEncoder().encodeToString(auth.getBytes());
    }
}
