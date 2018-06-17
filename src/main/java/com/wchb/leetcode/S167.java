package com.wchb.leetcode;

/**
 * @date 6/16/18 1:29 PM
 */

public class S167 {

    // 暴力枚举法
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(1)
    // 没有利用原数组的性质---有序
    // 有序? 二分搜索?
    public int[] twoSumV1(int[] numbers, int target) {

        if (numbers.length < 2 /*|| !isSorted(numbers)*/) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        throw new RuntimeException("No answers!");
    }


    // 二分搜索法
    // 时间复杂度: O(nlogn)
    // 空间复杂度: O(1)
    public int[] twoSumV2(int[] numbers, int target) {

        if (numbers.length < 2 /*|| !isSorted(numbers)*/) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }

        for (int i = 0; i < numbers.length; i++) {
            int temp = binarySearch(numbers, target - numbers[i]);
            if (temp != -1 && temp != i) {
                return temp > i ? new int[]{i + 1, temp + 1} : new int[]{temp + 1, i + 1};
            }
        }

        throw new RuntimeException("No answers!");
    }

    private int binarySearch(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    // 对撞指针
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int[] twoSumV3(int[] numbers, int target) {

        if (numbers.length < 2 /*|| !isSorted(numbers)*/) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }

        int l = 0, r = numbers.length - 1;

        while (l <= r) {
            if (target == numbers[l] + numbers[r]) {
                return new int[]{l + 1, r + 1};
            } else if (target > numbers[l] + numbers[r]) {
                l++;
            } else {
                r--;
            }
        }

        throw new RuntimeException("No answers!");
    }
}
