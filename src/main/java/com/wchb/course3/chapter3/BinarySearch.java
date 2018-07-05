package com.wchb.course3.chapter3;

/**
 * @date 6/16/18 10:24 AM
 */
public class BinarySearch {
    private BinarySearch() {
    }

    public static int binarySearch(Comparable[] arr, Comparable target) {

        int n = arr.length;

        // 在[l...r]的范围里寻找target
        int l = 0, r = n - 1;
        while (l <= r) { // 在[l...r]的范围里寻找target
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

    //V2: 改变将n的定义从arr.length-1 换到arr.length.
    public static int binarySearchV2(Comparable[] arr, Comparable target) {

        int n = arr.length;

        // 在[l...r)的范围里寻找target
        int l = 0, r = n;
        while (l < r) { // 在[l...r)的范围里寻找target
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) > 0) {
                l = mid + 1;// target 在[mid+1...r)中
            } else {
                r = mid;// target 在 [l...mid)中
            }
        }

        return -1;
    }
}
