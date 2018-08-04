package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 8/3/18 1:27 PM
 */
public class S16 {


    //暴力解法
    public int threeSumClosest(int[] nums, int target) {

        int min = Integer.MAX_VALUE;
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[k] + nums[j] + nums[i];
                    int newMin = Math.abs(sum - target);
                    if (newMin < min) {
                        min = newMin;
                        ret = sum;
                    }
                }
            }
        }

        return ret;
    }

    /************************************************************/

    //Two Pointer 解法
    public int threeSumClosestV2(int[] nums, int target) {


        Arrays.sort(nums);
        int length = nums.length;
        int ret = nums[length - 1] + nums[length - 2] + nums[length - 3];

        int index = 0;

        while (index < length - 2) {
            int start = index + 1;
            int end = length - 1;
            while (start < end) {
                //System.out.println(start+"---"+ end);
                int sum = nums[index] + nums[start] + nums[end];

                if (sum == target) {
                    return nums[index] + nums[start] + nums[end];
                } else if (sum > target) {
                    while (end - 1 >= 0 && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    end--;
                } else {
                    while (start + 1 < length && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                }

                if (Math.abs(sum - target) < Math.abs(ret - target)) {
                    ret = sum;
                }
            }
            index++;
        }

        return ret;
    }
}
