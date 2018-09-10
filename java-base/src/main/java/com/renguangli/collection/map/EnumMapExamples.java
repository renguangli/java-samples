package com.renguangli.collection.map;

import java.util.EnumMap;

/**
 * EnumMapExamples
 *
 * @author renguangli 2018/9/10 15:21
 * @since JDK 1.8
 */
public class EnumMapExamples {

    /**
     * 1、线程不安全
     * 2、键只能是枚举类型
     * 3、键不能是null
     */
    public static void main(String[] args) {
        EnumMap<Key, String> map = new EnumMap<>(Key.class);
        map.put(Key.one, "string");
        map.put(Key.two, "sdf");
        map.put(Key.three, null);
    }

}
