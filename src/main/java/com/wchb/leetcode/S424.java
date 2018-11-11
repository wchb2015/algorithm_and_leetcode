package com.wchb.leetcode;

/**
 * @date 11/10/18 5:14 PM
 */
public class S424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() <= k) return s.length();
        int[] count = new int[26];

        int ans = 0;
        int maxRepeatChar = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {

            char cur = s.charAt(end);
            count[cur - 'A']++;
            maxRepeatChar = Math.max(maxRepeatChar, count[cur - 'A']);
            while (end - start + 1 - maxRepeatChar > k) {
                count[s.charAt(start) - 'A']--;
                start++;
                for (int i : count) maxRepeatChar = Math.max(maxRepeatChar, i);
            }

            ans = Math.max(ans, end - start + 1);

            System.out.println(start + "----" + end);
        }

        return ans;
    }
}
