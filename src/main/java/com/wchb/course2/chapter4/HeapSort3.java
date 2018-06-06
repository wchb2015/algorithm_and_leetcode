package com.wchb.course2.chapter4;

/**
 * @date 6/2/18 4:03 PM
 */

// 不使用一个额外的最大堆, 直接在原数组上进行原地排序
public class HeapSort3 {

    // 我们的算法类不允许产生任何实例
    private HeapSort3() {
    }

    public static void sort(Comparable[] arr) {

        int length = arr.length;

        // 注意,此时我们的堆是从0开始索引的
        // 这时: 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown2(arr, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown2(arr, i, 0);
        }

    }


    /**
     * @param arr 存堆的数组
     * @param k
     * @param i   被shiftDown的元素的角标
     */
    private static void shiftDown2(Comparable[] arr, int k, int i) {

        int length = k;
        Comparable e = arr[i];

        while (length > 2 * i + 1) {
            int j = 2 * i + 1;
            if (j + 1 < length && arr[j + 1].compareTo(arr[j]) > 0) {
                j = j + 1;
            }

            if (e.compareTo(arr[j]) >= 0) {
                break;
            }

            arr[i] = arr[j];
            i = j;
        }


        arr[i] = e;

    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
