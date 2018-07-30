package com.wchb.leetcode;

/**
 * @date 7/29/18 7:14 PM
 */
public class S541 {
    public String reverseStr(String s, int k) {

        if (s == null || s.length() == 0 || k <= 1) return s;

        int len = s.length();
        char[] arr = s.toCharArray();

        if (k >= len) {
            reverse(arr, 0, len - 1);
            return new String(arr);
        }

        boolean reverse = true;
        for (int i = 0; i < len; i += k) {
            if (reverse) {
                if (i + k >= len) {
                    reverse(arr, i, len - 1);
                    break;
                }
                reverse(arr, i, i + k - 1);
                reverse = false;
            } else {
                reverse = true;
            }
        }

        return new String(arr);
    }


    // reverse arr [start,end]
    private void reverse(char[] arr, int start, int end) {

        int mid = (start + end) / 2;

        for (int i = start; i <= mid; i++, end--) {
            char temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
        }
    }
}
