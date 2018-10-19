package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/19/18 3:18 PM
 */
public class S448 {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[nums[i]]++;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) ans.add(i);
        }
        return ans;
    }

    /************************************************************/

    //The basic idea is that we iterate through the input array and mark elements as negative
    // using nums[nums[i] -1] = -nums[nums[i]-1].
    // In this way all the numbers that we have seen will be marked as negative.
    // In the second iteration, if a value is not marked as negative,
    // it implies we have never seen that index before, so just add it to the return list.
    public List<Integer> findDisappearedNumbersV1(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) continue;
            nums[Math.abs(nums[i]) - 1] *= -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        
        return ans;
    }
}
