package com.wchb.course2.chapter3;

import java.util.Arrays;

/**
 * @date 6/8/18 2:37 PM
 */
public class MergeSort {


    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // 递归使用归并排序, 对 arr[l...r] 的范围进行排序
    private static void mergeSort(Comparable[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }

    }

    // 将arr[l...mid] 和 arr[mid+1...r] 两部分进行归并
    public static void merge(Comparable[] arr, int l, int mid, int r) {

        //copyOfRange 含头不含尾
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化,i指向左半部分的起始索引位置l;j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }

        }

    }
}
