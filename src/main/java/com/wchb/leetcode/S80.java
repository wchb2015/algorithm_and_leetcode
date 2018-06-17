package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

/**
 * @date 6/16/18 7:14 PM
 */
public class S80 {

    @CreatedByMyself
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;//指向去重后数组的最后一个元素
        int repeatTimes = 1;

        for (int j = 1; j < nums.length; j++) {

            if (nums[i] == nums[j]) {
                repeatTimes++;
                if (repeatTimes > 2) {
                    continue;
                } else {
                    nums[++i] = nums[j];
                }
            } else {
                repeatTimes = 1;
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }

}
