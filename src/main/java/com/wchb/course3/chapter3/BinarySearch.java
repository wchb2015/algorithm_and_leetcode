package com.wchb.course3.chapter3;

/**
 * @date 6/16/18 10:24 AM
 */
public class BinarySearch {
    private BinarySearch() {
    }

    public static int binarySearch(Comparable[] arr, int n, Comparable target) {

        // 在[l...r]的范围里寻找target
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
