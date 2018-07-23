package com.renguangli.string;

import sun.applet.Main;

/**
 * String使用方法和常见面试题
 */
public class StringExamples {

    /**
     * 使用方法
     */
    public void use() {
        /*
         * 创建字符串的几种方式
         */
        //方式一
        String s1 = "str";
        //方式二
        String s2 = new String("str");
    }

    public static void main(String[] args) {
        String s1 = "dali";
        String s2 = new String("dali");
        String s3 = new String("dali").intern();
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//true
        System.out.println(s2 == s3);//false
    }
}
