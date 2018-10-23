package com.renguangli.abstract_interface;

import java.util.List;

/**
 * 接口用 interface 关键字修饰
 * 只能有抽象方法
 * 可以继承多个接口，用逗号 , 隔开，如果继承了有默认方法的接口需要实现默认方法
 *
 * @author renguangli 2018/10/19 14:38
 * @since JDK 1.8
 */
public interface InterfaceExamples extends List, Runnable {

    int age = 10;
    // 接口变量修饰符默认为 public static final
    static final String name = "dali";

    // JDK8 可以有默认方法，访问权限默认 public
    public default void show(){}

    // JDK8 可以有静态方法，访问权限默认 public
    public static void request(){}

    // 不能有普通方法
    //public void response(){}

    void doRequest();
    // 抽象方法，默认修饰符为 public abstract
    // 这可以理解，抽象方法就是实现类用来实现的，所以访问权限必须是 public
    public abstract void doResponse();

    @Override
    default void run() {

    }
}
