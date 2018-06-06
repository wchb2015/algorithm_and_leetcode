package com.wchb.leetcode;

/**
 * @date 6/5/18 6:15 PM
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
public class S303V2 {

    class NumArray {

        // sum[i]存储前i个元素和.  sum[0]=0
        // sum[i] 存储nums[0.... i-1] 的和
        private int[] sum;


        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = 0;

            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
