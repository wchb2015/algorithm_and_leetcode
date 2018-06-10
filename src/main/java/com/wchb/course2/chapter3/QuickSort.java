package com.wchb.course2.chapter3;

import com.wchb.course2.util.SortHelper;

/**
 * @date 6/9/18 2:36 PM
 */
public class QuickSort {

    // 我们的算法类不允许产生任何实例
    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];
        //arr[l+1...j]<v; arr[j+1....i)>v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                SortHelper.swap(arr, j, i);
            }
        }
        SortHelper.swap(arr, l, j);
        return j;
    }

}
