package com.renguangli.datastructure.link;


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
        OneLink<Integer> oneLink = new OneLink<Integer>();
        oneLink.add(1);
        oneLink.add(2);
        oneLink.add(3);
        oneLink.add(4);
        oneLink.add(5);
        oneLink.print();

        System.out.println("-------------------");

       /* System.out.println(oneLink.size());
        System.out.println(oneLink.getFirst());
        System.out.println(oneLink.getLast());*/

        System.out.println(oneLink.get(4));
    }

}