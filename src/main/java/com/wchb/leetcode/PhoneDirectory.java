package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 3/22/19 3:16 PM
 */
public class PhoneDirectory {


    int[] arr;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        arr = new int[maxNumbers];
        Arrays.fill(arr, -1);
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                arr[i] = 1;
                return i;
            }
        }
        return -1;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return arr[number] == -1;
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {

        arr[number] = -1;
    }
}
