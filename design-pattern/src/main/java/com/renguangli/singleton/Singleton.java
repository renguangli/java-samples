package com.renguangli.singleton;

/**
 * Singleton 懒汉式单例模式-线程不安全
 *
 * @author renguangli 2018/7/23 16:59
 * @since JDK 1.8

public class Singleton {

    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
 */

/**
 * Singleton 懒汉式单例模式-线程安全
 *
 * @author renguangli 2018/7/23 16:59
 * @since JDK 1.8
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance() {
        return instance;
    }
}
