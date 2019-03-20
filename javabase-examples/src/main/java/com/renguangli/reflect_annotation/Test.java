package com.renguangli.reflect_annotation;

/**
 * javabase-examples
 * Created by renguangli at 2019/3/20 16:14
 *
 * @since JDK1.8
 */
@Value("aaaa")
public class Test {

    private static final String test = "test";

    private int id;

    String name;
    protected String name1;
    public String name2;

    public Test(){}

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getTest() {
        return test;
    }

    public void setName(String name) {
        this.name = name;
    }

}
