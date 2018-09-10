package com.renguangli.collection.map;

import java.util.TreeMap;

/**
 * TreeMapExamples
 *
 * @author renguangli 2018/9/10 15:20
 * @since JDK 1.8
 */
public class TreeMapExamples {

    /**
     * 1、线程不安全
     * 2、健不能是null
     * 3、健按自然升序排序
     */
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("concurrentHashMap", "concurrentHashMap");
        map.put("concurrentSkipListMap", "ConcurrentSkipListMap");
        map.put("hashMap", "hashMap");
        map.put("treeMap", "treeMap");
        map.put("linkedHashMap", "linkedHashMap");
        map.put("enumMap", "EnumMap");

        map.put("map", null);

        map.keySet().forEach(System.out::println);
    }
}
