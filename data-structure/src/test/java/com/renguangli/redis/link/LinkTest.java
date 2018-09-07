package com.renguangli.redis.link;


import org.junit.Test;

/**
 * LinkTest
 *
 * @author renguangli 2018/7/11 9:56
 * @since JDK 1.8
 */
public class LinkTest {

    private Link<Integer> link = new Link<Integer>();

    @Test
    public void test() {
        link.add(1);
        int length = link.length();

        System.out.println(length);
    }

}