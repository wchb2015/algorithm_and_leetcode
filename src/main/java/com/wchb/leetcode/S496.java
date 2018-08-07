package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @date 8/5/18 10:25 PM
 */
public class S496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = find(nums1[i], nums2);
            ret[i] = search(nums1[i], index + 1, nums2);
        }

        return ret;
    }


    private int find(int target, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }

        return -1;
    }


    private int search(int target, int startIndex, int[] array) {
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] > target) {
                return array[i];
            }
        }

        return -1;
    }

    /************************************************************/
    public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

}
