package com.renguangli.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * CollectionExamples
 *
 * @author renguangli 2018/8/20 17:08
 * @since JDK 1.8
 */
public class CollectionExamples {

    public static void main(String[] args) {
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("str", "str");

        String[] strs = {"e", "sdf", "sdfd", "kljadg", "sdfsdfsdf", "jcj","s","o"};

        String sdfd = "s";
        int i = (strs.length - 1) & sdfd.hashCode();
        System.out.println(i);
        System.out.println(sdfd.hashCode() % strs.length);
    }


}
