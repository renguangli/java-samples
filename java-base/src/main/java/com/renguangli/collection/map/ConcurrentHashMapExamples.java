package com.renguangli.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMapExamples
 *
 * @author renguangli 2018/9/10 15:20
 * @since JDK 1.8
 */
public class ConcurrentHashMapExamples {

    /**
     * 1、线程安全
     * 2、键值不能为null
     */
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put(null, "str"); // NullPointerException
        map.put("str", null); // NullPointerException
    }
}
