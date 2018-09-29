package com.renguangli.collection.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * HashTableExamples
 *
 * @author renguangli 2018/9/20 11:48
 * @since JDK 1.8
 */
public class HashTableExamples {

    public static void main(String[] args) {
        Map<String, String> map = new Hashtable<>();
        map.put("", "sdf");
        map.put("sdf", "sdf");
    }
}
