package com.wchb.leetcode;

/**
 * @date 6/16/18 3:20 PM
 */
public class S3 {

    // 滑动窗口
    // 时间复杂度: O(len(s))
    // 空间复杂度: O(len(charset))
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        int[] freq = new int[256];
        int l = 0, r = -1;
        int ret = 0;
        char[] arr = s.toCharArray();
        int length = arr.length;

        while (l < length) {
            System.out.println(l + " === " + r + " ret: " + ret);
            if (r + 1 < length && freq[arr[r + 1]] == 0) {
                r++;
                freq[arr[r]]++;
            } else {
                freq[arr[l]]--;
                l++;
            }
            ret = Math.max(ret, r - l + 1);
        }

        return ret;
    }
}

