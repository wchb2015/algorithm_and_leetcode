package com.wchb.leetcode;

/**
 * @date 8/10/18 3:47 PM
 */
public class S238 {

    //https://segmentfault.com/a/1190000003768224

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            ans[i] = left;
        }

        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            ans[i] = ans[i] * right;
        }

        return ans;
    }
}
