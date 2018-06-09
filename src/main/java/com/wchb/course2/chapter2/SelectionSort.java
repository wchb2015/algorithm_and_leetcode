package com.wchb.course2.chapter2;

import com.wchb.course2.util.SortHelper;

/**
 * @date 6/8/18 2:20 PM
 */
public class SelectionSort {
    // 我们的算法类不允许产生任何实例
    private SelectionSort() {
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            SortHelper.swap(arr, i, minIndex);
        }
    }


}
