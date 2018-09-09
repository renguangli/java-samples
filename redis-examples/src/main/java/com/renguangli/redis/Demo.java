package com.renguangli.redis;

/*
 * 类的初始化过程
 * Created by renguangli at 2018/9/9 19:29
 * @since JDK1.8
 */
public class Demo {

    static Demo demo = new Demo();
    static int a;
    static int b = 0;

    static {
        System.out.println(a + " " + b);
    }

    public Demo() {
        a++;
        b++;
    }

    public static void main(String[] args) {
        System.out.println(a + " " + b);
    }
}
