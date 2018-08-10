package com.wchb.leetcode;

/**
 * @date 8/9/18 11:09 AM
 */
public class S53 {


    public int maxSubArray(int[] nums) {

        int ret = nums[0];

        int[] memo = new int[nums.length];

        //memo[i]  maxSubArray(0...i);
        //f[i]  = f[i-1]>0? nums[i]+f[i-1]: nums[i];

        memo[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(memo[i - 1] + nums[i], nums[i]);
            ret = Math.max(ret, memo[i]);
        }


        return ret;
    }

    /************************************************************/

    public int maxSubArrayV2(int[] nums) {

        int ret = nums[0];


        //memo[i]  maxSubArray(0...i);
        //f[i]  = f[i-1]>0? nums[i]+f[i-1]: nums[i];

        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ret = Math.max(ret, pre);
        }

        return ret;
    }

}
