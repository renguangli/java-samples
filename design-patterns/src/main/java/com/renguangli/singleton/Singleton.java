package com.renguangli.singleton;

/**
 * Singleton 懒汉式单例模式（线程不安全-延迟加载）
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
 * Singleton 懒汉式单例模式（线程安全-延迟加载）
 *
 * @author renguangli 2018/7/23 16:59
 * @since JDK 1.8

public class Singleton {

    private static Singleton instance;

    private Singleton(){}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
 */

/**
 * Singleton 饿汉式单例模式（线程安全）
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



/**
 * Singleton 双重校验锁单例模式（线程安全-延迟加载）
 *
 * @author renguangli 2018/7/23 16:59
 * @since JDK 1.8
public class Singleton {

    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
 */

    /**
     * Singleton cas实现的单例模式(线程安全-延迟加载)
     *
     * @author renguangli 2018/7/23 16:59
     * @since JDK 1.8

    public class Singleton {

        private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<>();

        public static AtomicInteger count = new AtomicInteger(0);

        private Singleton() {
            System.out.println(count.incrementAndGet());
        }

        public static Singleton getInstance() {
            for (;;) {
                Singleton singleton = INSTANCE.get();
                if (null != singleton) {
                    return singleton;
                }

                singleton = new Singleton();
                if (INSTANCE.compareAndSet(null, singleton)) {
                    return singleton;
                }
            }
        }
    }
 */
/**
 * Singleton 静态内部单例模式(线程安全-延迟加载)
 *
 * @author renguangli 2018/7/23 16:59
 * @since JDK 1.8

public class Singleton {

    private static class SingletonHolder{
        private static Singleton instance = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
 */

/**
 * 枚举实现的单例模式(线程安全)

public enum  Singleton {

    INSTANCE;

}
 */