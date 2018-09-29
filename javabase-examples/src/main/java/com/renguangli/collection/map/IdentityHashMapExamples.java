package com.renguangli.collection.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * IdentyHashMapExamples
 *
 * @author renguangli 2018/9/25 16:47
 * @since JDK 1.8
 */
public class IdentityHashMapExamples {

    static Map<String, String> map = new IdentityHashMap<>();

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put(new String("aaa"), "aaa");
        map.put(new String("aaa"), "bbb");
        System.out.println(map);
    }

}
