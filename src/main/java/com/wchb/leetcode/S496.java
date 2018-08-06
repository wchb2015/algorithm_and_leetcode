package com.wchb.leetcode;

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

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
        }

        return ret;
    }

}
