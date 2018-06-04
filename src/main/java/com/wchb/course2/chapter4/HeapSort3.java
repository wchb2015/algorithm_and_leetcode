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
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown2(arr, length, i);
        }

    }

    private static void shiftDown2(Comparable[] arr, int length, int i) {

    }

}
