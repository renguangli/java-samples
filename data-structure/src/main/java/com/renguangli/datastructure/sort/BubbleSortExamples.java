package com.renguangli.datastructure.sort;

/**
 * BubbleSortExamples 冒泡排序
 *
 * @author renguangli 2018/8/23 9:41
 * @since JDK 1.8
 */
public class BubbleSortExamples {

    /*
     * 工作原理: 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
     * 平均时间复杂度为 ：
     * 稳定性: 冒牌选择排序是稳定的排序方法。
     */

    /**
     * 冒泡排序经典实现
     *
     * @param a 待排序数组
     */
    public void bubbleSort(int[] a) {
        int tmp,length = a.length;
        for (int i = 0; i < length - 1; i++) { // 第一层循环,比较次数
            for (int j = 0; j < length - i - 1; j++) {// 比较交换元素位置
                if (a[j] > a[j + 1]) {
                    tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    /*
     * 优化冒泡排序
     */
    public void bubbleSort2(int[] a) {
        int tmp,length = a.length;
        for (int i = 0; i < length - 1; i++) { //第一层循环,比较次数
            boolean flag = false; // 提前退出冒泡循环的标志位
            for (int j = 0; j < length - i - 1; j++) { //比较交换元素位置
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true; // true 表示有数据交换
                }
            }
            if (!flag) break;// 没有数据交换，提前退出
        }
    }

}
