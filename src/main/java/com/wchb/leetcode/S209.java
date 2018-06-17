package com.wchb.leetcode;

/**
 * @date 6/16/18 2:22 PM
 */
public class S209 {

    // 暴力解法
    // 该方法在 Leetcode 中会超时！
    // 时间复杂度: O(n^3)
    // 空间复杂度: O(1)
    // 暴力求一个数组的所有子数组;
    public int minSubArrayLenV1(int s, int[] nums) {
        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illegal Arguments");
        }

        int res = nums.length + 1;

        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                int sum = 0;
                for (int i = l; i <= r; i++) {
                    sum += nums[i];
                }
                if (sum >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }

        return res;
    }


    // 优化暴力解
    // 时间复杂度: O(n^2)
    // 空间复杂度: O(n)
    public int minSubArrayLenV2(int s, int[] nums) {
        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illigal Arguments");
        }

        int res = nums.length + 1;
        // sums[i]存放nums[0...i-1]的和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int l = 0; l < nums.length; l++) {
            for (int r = l; r < nums.length; r++) {
                // 使用sums[r+1] - sums[l] 快速获得nums[l...r]的和
                if (sums[r + 1] - sums[l] >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }

        return res;
    }

    public int minSubArrayLenV3(int s, int[] nums) {
        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illigal Arguments");
        }

        int res = nums.length + 1;

        if (res == nums.length + 1) {
            return 0;
        }

        return res;
    }

    // 滑动窗口的思路
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int minSubArrayLenV4(int s, int[] nums) {
        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illigal Arguments");
        }

        int res = nums.length + 1;

        int l = 0, r = -1;//nums[l...r]为滑动窗口
        int sum = 0;

        while (l < nums.length) {
            System.out.println(l + " ==== " + r + " sum " + sum + " res= " + res);
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }

        return res;
    }
}
