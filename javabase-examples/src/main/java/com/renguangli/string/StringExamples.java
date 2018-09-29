package com.renguangli.string;


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
 /*       String s1 = "dali";
        final String s2 = new String("dali");
        String s3 = s2.intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);*/


        String baseStr = "baseStr";
        final String baseFinalStr = "baseStr";

        String str1 = "baseStr01";
        String str2 = "baseStr"+"01";
        String str3 = baseStr + "01";
        String str4 = baseFinalStr+"01";
        String str5 = new String("baseStr01").intern();

        System.out.println(str1 == str2);//#3  true
        System.out.println(str1 == str3);//#4 false
        System.out.println(str1 == str4);//#5 true
        System.out.println(str1 == str5);//#6 true
    }
}
