package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date 6/18/18 1:34 PM
 */
public class S219 {

    // Using Hash Set
    // Time Complexity: O(n)
    // Space Complexity: O(k)
    public boolean containsNearbyDuplicateV2(int[] nums, int k) {

        // 题目给的参数,一般都是先校验再使用
        if (nums.length < 2 || k <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    /************************************************************/
    @CreatedByMyself
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // 题目给的参数,一般都是先校验再使用
        if (nums.length < 2 || k <= 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = nums.length;


        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                ans = Math.min(ans, Math.abs(map.get(nums[i]) - i));
            }
            map.put(nums[i], i);
        }

        return ans != nums.length && ans <= k;
    }

}
