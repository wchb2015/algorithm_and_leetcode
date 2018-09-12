package com.wchb.leetcode;

/**
 * @date 9/11/18 2:46 PM
 */
public class S673 {

    int[] memo;
    int[] len;
    int n;

    public int findNumberOfLIS(int[] nums) {
        n = nums.length;
        memo = new int[n];
        len = new int[n];

        if (n <= 1) return n;

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            maxLen = Math.max(maxLen, getMaxLength(nums, i));
        }

        // Checking all endings.
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (getMaxLength(nums, i) == maxLen) {
                ans += count(nums, i);
            }
        }

        return ans;
    }

    // Number of LIS ends with nums[i]
    private int count(int[] nums, int i) {
        if (i == 0) return 1;
        if (len[i] != 0) return len[i];

        int totalCount = 0;
        int maxLength = getMaxLength(nums, i);
        for (int j = 0; j < i; j++)
            if (nums[i] > nums[j] && getMaxLength(nums, j) == maxLength - 1)
                totalCount += count(nums, j);

        if (totalCount == 0)
            totalCount = 1;

        len[i] = totalCount;
        return totalCount;
    }

    // Length of LIS ends with nums[n]
    private int getMaxLength(int[] nums, int start) {
        if (memo[start] != 0) return memo[start];
        int ans = 1;

        // Check every subarray
        for (int i = 0; i <= start - 1; i++) {
            if (nums[i] < nums[start]) {
                ans = Math.max(ans, 1 + getMaxLength(nums, i));
            }
        }
        memo[start] = ans;
        return ans;
    }
}
