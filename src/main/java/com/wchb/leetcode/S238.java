package com.wchb.leetcode;

/**
 * @date 8/10/18 3:47 PM
 */
public class S238 {

    //https://segmentfault.com/a/1190000003768224

    // 分析出自身以外数组乘积的性质，
    // 它实际上是自己左边左右数的乘积，
    // 乘上自己右边所有数的乘积。
    // 所以我们可以用一个数组left[i]来表示第i个数字(nums[i])前面数的乘积，这样left[i] = left[i-1] nums[i-1]。
    // 同理，我们可以反向遍历一遍生成另一个数组right[i] = right[i + 1] nums[i+1]。
    // 得到这两个数组后，我们再遍历一遍，把每个位置的left[i]乘上right[i]就行了
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];


        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
