package com.wchb.course2.chapter3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date 6/9/18 12:07 PM
 */
public class MergeSortBU {

    private static final Logger logger = LoggerFactory.getLogger(MergeSortBU.class);

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n - sz; i += sz + sz) {
//                logger.info("sz:{},l:{},mid:{},r:{}", sz, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
                MergeSort.merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }

    }


    // 将arr[l...mid] 和 arr[mid+1...r] 两部分进行归并
    // merge(Comparable[] arr, int l, int mid, int r)
}
