package com.renguangli.box;

/**
 * BoxExamples
 *
 * @author renguangli 2018/9/17 16:00
 * @since JDK 1.8
 */
public class BoxExamples {

    public static void main(String[] args) {
        Integer i = 10; // 自动装箱
        int j = i; // 自动拆箱

        Integer a = 123;
        Integer b = 123;
        System.out.println(a == b);

        Integer x = 1234;
        Integer y = 1234;
        System.out.println(x == y);
    }

}
