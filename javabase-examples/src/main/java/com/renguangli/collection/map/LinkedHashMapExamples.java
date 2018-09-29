package com.renguangli.collection.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMapExamples
 *
 * @author renguangli 2018/9/10 15:20
 * @since JDK 1.8
 */
public class LinkedHashMapExamples {

    /**
     * 1、键值可以为null
     * 2、键按插入顺序排序
     */
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put(null, null);
        map.put(null, null);
        map.put("map", null);
        map.put("map3", null);
        map.put("map2", null);
        map.put("map4", null);
        map.keySet().forEach(System.out::println);
    }

}
