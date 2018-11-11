package com.wchb.leetcode;

/**
 * @date 11/6/18 7:50 PM
 */
public class S340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int distinct = 0, l = 0, ans = 0;

        for (int r = 0; r < s.length(); r++) {
            if (count[s.charAt(r)] == 0) distinct++;
            count[s.charAt(r)]++;

            //if there are more distinct char. Start removing from left until distinct Chars == k
            while (distinct > k) {
                count[s.charAt(l)]--;

                if (count[s.charAt(l)] == 0) distinct--;

                l++;
            }
            ans = Math.max(ans, r - l + 1);

        }
        return ans;
    }
}
