package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 6/9/18 2:07 PM
 */
public class S75 {

    //计数排序
    //Time: O(n)
    //Space: O(k) K为元素取值范围
    //Space: O(1) 常数级别
    public void sortColorsV1(int[] nums) {
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

    }

    /************************************************************/

    // 三路快速排序的思想
    // 对整个数组只遍历了一遍
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    // [0...zero] == 0
    // [zero+1...i-1] == 1
    // [two...n-1] == 2
    public void sortColorsV2(int[] nums) {
        int zero = -1;          // [0...zero] == 0
        int two = nums.length;  // [two...n-1] == 2
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                //此时i不动,继续处理i
                swap(nums, i, --two);
            } else { // nums[i] == 0
                // zero后的数一定为1
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }


        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
