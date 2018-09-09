package com.renguangli.algorithm.sort;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;

/*
 * 排序算法测试代码
 * Created by renguangli at 2018/8/22 20:53
 * @since JDK1.8
 */
public class SortExamplesTest {

    private int[] array = {1, 45, 27, 3, 67, 4, 3, 9};

    @After
    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void bubbleSortTest() {
        BubbleSortExamples.bubbleSort(array);
    }

}
