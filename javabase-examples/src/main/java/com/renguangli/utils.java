package com.renguangli;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * utils
 *
 * @author renguangli 2018/11/6 16:31
 * @since JDK 1.8
 */
public class utils {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "http://172.16.13.125/blogic/api/search/stats?searchIndex=rocketmq_response*&widgetType=table&beginDate=0&query=";
        String query = "statusCode:200| count(*) as total group by api.keyword,version.keyword,apiPublisher.keyword,username.keyword,applicationName.keyword";
        try {
            url = url + URLEncoder.encode(query, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String s = WebClientUtil.doGet(url, null);
        System.out.println(s);
    }
}
