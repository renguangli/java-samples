package com.renguangli.datastructure.sort;


import org.junit.After;
import org.junit.Test;

import java.util.Arrays;

/**
 * SortExamplesTest
 *
 * @author renguangli 2018/8/23 9:42
 * @since JDK 1.8
 */
public class SortExamplesTest {

    private int[] a = {23, 1, 2, 7, 4, 8, 6, 9, 45, 3};

    @After
    public void print() {
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void bubbleSortTest() {
        BubbleSortExamples.bubbleSort(a);
    }

    @Test
    public void selectSortTest() {
        SelectSortExamples.selectSort(a);
    }

}