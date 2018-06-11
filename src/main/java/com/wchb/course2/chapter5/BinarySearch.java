package com.wchb.course2.chapter5;

/**
 * @date 6/10/18 4:47 PM
 */

public class BinarySearch {

    // 我们的算法类不允许产生任何实例
    private BinarySearch() {
    }

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public static int find(Comparable[] arr, Comparable target) {

        //在 arr[l...r]之间寻找 target
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
            int mid = l + (r - l) / 2;

            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                //在 arr[mid+1....r]之中查找target
                l = mid + 1;
            } else {
                //在 arr[l...mid-1] 之中查找target
                r = mid - 1;
            }
        }
        return -1;
    }

    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1 递归算法
    public static int find2(Comparable[] arr, Comparable target) {
        //在 arr[l...r]之间寻找 target
        int l = 0, r = arr.length - 1;
        return find2(arr, l, r, target);
    }

    private static int find2(Comparable[] arr, int l, int r, Comparable target) {
        int mid = l + (r - l) / 2;
        if (l >= r) {
            return arr[mid].compareTo(target) == 0 ? mid : -1;
        }
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        } else if (arr[mid].compareTo(target) < 0) {
            //在 arr[mid+1....r]之中查找target
            return find2(arr, mid + 1, r, target);
        } else {
            //在 arr[l...mid-1] 之中查找target
            return find2(arr, l, mid - 1, target);
        }
    }
}
