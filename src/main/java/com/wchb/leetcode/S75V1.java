package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 6/9/18 2:07 PM
 */
public class S75V1 {

    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                red += 1;
            } else if (nums[i] == 1) {
                white += 1;
            } else {
                blue += 1;
            }
        }

        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }
        for (int i = red; i < red + white; i++) {
            nums[i] = 1;
        }
        for (int i = red + white; i < red + white + blue; i++) {
            nums[i] = 2;
        }

//        System.out.println(Arrays.toString(nums));
    }

}
