package com.wchb.course2.chapter3;

import com.wchb.course2.util.SortHelper;

import java.util.Arrays;

/**
 * @date 6/9/18 4:07 PM
 */
public class QuickSort2 {
    // 我们的算法类不允许产生任何实例
    private QuickSort2() {
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
        int p = partition2(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    public static int partition2(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
//        SortHelper.swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        System.out.println(Arrays.toString(arr));

        Comparable v = arr[l];

        // arr[l+1...i)<=v; arr(j...r]>=v;
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
                System.out.println("--------- i: " + i);
            }
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
                System.out.println("--------- j: " + j);
            }
            if (i > j) {
                break;
            }
            SortHelper.swap(arr, i, j);
            i++;
            j--;
        }

        SortHelper.swap(arr, l, j);

        return j;
    }

}
