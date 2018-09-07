package com.renguangli.redis.sort;

/**
 * SelectSortExamples 选择排序
 *
 * @author renguangli 2018/8/23 13:59
 * @since JDK 1.8
 */
public class SelectSortExamples {

    /*
     * 工作原理: 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
     * 时间复杂度：
     * 稳定性: 选择排序是不稳定的排序方法。
     */

    /**
     * 选择排序
     * @param a 待排序数组
     */
    public static void selectSort(int[] a) {
        int min, tmp, length = a.length;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

}
