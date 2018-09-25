package com.renguangli.interesting;

/**
 * A
 *
 * @author renguangli 2018/9/11 18:38
 * @since JDK 1.8
 */
public class A {
    String s;

    public A() {
        System.out.println(1);
    }

    public A(String s) {
        System.out.println(2);
        this.s = s;
    }
}
