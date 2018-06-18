package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

/**
 * @date 6/17/18 5:00 PM
 */
public class S345 {


    @CreatedByMyself
    public String reverseVowels(String s) {

        if (s == null || s.trim().length() == 0) {
            return s;
        }

        char[] arr = s.toCharArray();

        int l = 0, r = arr.length - 1;

        while (l < r) {

            if (!isVowel(arr[l])) {
                l++;
            } else if (!isVowel(arr[r])) {
                r--;
            } else {
                swap(arr, l, r);
                l++;
                r--;
            }


        }

        return String.valueOf(arr);
    }

    private void swap(char[] arr, int l, int r) {
        char temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
