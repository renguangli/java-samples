package com.renguangli.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Producer
 *
 * @author renguangli 2018/9/20 13:28
 * @since JDK 1.8
 */
public class Producer implements Runnable {
    @Override
    public void run() {

    }

    /**
     * list去重
     */
    @Test
    public void distinct() {
        List<Integer> list = of(1,2,3,4,5,2,3);
        System.err.println(list);

        //stream去重
        //List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
//        System.err.println(collect);

//        Set<Integer> set = new HashSet<>(list);
//        System.err.println(new ArrayList<>(set));

        List<Integer> list1 = new ArrayList<>();
        for (Integer integer : list) {
            if (!list1.contains(integer)) {
                list1.add(integer);
            }
        }
        list = null;
        System.out.println(list1);



    }


    public static List<Integer> of(Integer... e) {
        return Arrays.asList(e);
    }
}
