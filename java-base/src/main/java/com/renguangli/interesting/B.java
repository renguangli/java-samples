package com.renguangli.interesting;

/**
 * B
 *
 * @author renguangli 2018/9/11 18:39
 * @since JDK 1.8
 */
public class B extends A {

    B b;

    public B(String s) {
        System.out.println(3);
        this.s = s;
        this.b = new B("hh");
    }

    public B() {
        System.out.println(4);
    }
}
