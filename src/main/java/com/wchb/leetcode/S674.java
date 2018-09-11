package com.wchb.leetcode;

/**
 * @date 9/10/18 1:37 PM
 */
public class S674 {


    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int n = nums.length;
        if (n == 0) return 0;
        for (int i = 1; i < n; i++) {
            if (n - i < ans) break;
            ans = Math.max(ans, helper(nums, i));
        }
        return ans;
    }


    private int helper(int[] nums, int i) {
        int ans = 1;

        while (i < nums.length) {
            if (nums[i] > nums[i - 1]) {
                ans++;
            } else {
                break;
            }
            i++;
        }

        return ans;
    }

    /************************************************************/

    public int findLengthOfLCISV2(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                anchor = i;
            }
            ans = Math.max(ans, i - anchor + 1);
        }

        return ans;
    }
}
