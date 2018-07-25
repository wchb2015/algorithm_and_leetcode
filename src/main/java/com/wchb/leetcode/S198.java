package com.wchb.leetcode;


/**
 * @date 6/22/18 2:37 PM
 */
public class S198 {


    //暴力解法:检查所有的房子的组合,对于每一个组合,检查是否有相邻的房子,如果没有,记录其价值,找最大值
    //O((2^n)*n) 组合问题
    int[] cache;

    public int rob(int[] nums) {

        cache = new int[nums.length];
        return tryRob(nums, 0);

    }

    private int tryRob(int[] nums, int index) {
        System.out.println("cal : " + index);

        if (index >= nums.length) return 0;

        if (cache[index] != 0) {
            System.out.println(index);
            return cache[index];
        }

        int a = nums[index] + tryRob(nums, index + 2);
        int b = 0 + tryRob(nums, index + 1);

        int ret = Math.max(a, b);
        cache[index] = ret;
        return ret;
    }

    /************************************************************/
    //递归+记忆
    int[] cache2;

    public int rob2(int[] nums) {
        cache2 = new int[nums.length];
        return tryRob2(nums, 0);
    }

    private int tryRob2(int[] nums, int index) {
        if (index >= nums.length) return 0;

        if (cache2[index] != 0) {
            System.out.println(index);
            return cache2[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob2(nums, i + 2));
        }

        cache2[index] = res;
        return res;
    }

    /************************************************************/
    //DP
    public int rob3(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[n];

        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            //memo[i]
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }

    /************************************************************/
    //DP
    public int rob4(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
