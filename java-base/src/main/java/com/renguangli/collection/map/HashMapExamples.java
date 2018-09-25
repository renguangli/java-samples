package com.renguangli.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * CollectionExamples
 *
 * @author renguangli 2018/9/10 15:20
 * @since JDK 1.8
 */
public class HashMapExamples {

    /**
     *
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("concurrentHashMap", "concurrentHashMap");
        map.put("ConcurrentSkipListMap", "ConcurrentSkipListMap");
        map.put("hashMap", "hashMap");
        map.put("treeMap", "treeMap");
        map.put("linkedHashMap", "linkedHashMap");
        map.put("enumMap", "EnumMap");

        map.put(null, null);
        map.put(null, null);
        map.put("map", null);

        map.keySet().forEach(System.out::println);

        System.out.println("=======================");

        map.values().forEach(System.out::println);
    }
}
