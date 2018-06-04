package com.wchb.leetcode;

/**
 * @date 6/4/18 10:04 AM
 */
public class Solution344 {

    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] charArray = s.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length / 2; i++) {
            swap(charArray, i, length - i - 1);
        }

        return String.valueOf(charArray);
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[j];
        charArray[j] = charArray[i];
        charArray[i] = temp;
    }
}
