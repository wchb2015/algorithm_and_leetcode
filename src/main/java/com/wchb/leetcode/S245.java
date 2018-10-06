package com.wchb.leetcode;

/**
 * @date 8/4/18 8:00 AM
 */
public class S245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;

        if (!word1.equals(word2)) {
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) {
                    if (idx2 != -1) ans = Math.min(ans, i - idx2);
                    idx1 = i;
                } else if (words[i].equals(word2)) {
                    if (idx1 != -1) ans = Math.min(ans, i - idx1);
                    idx2 = i;
                }
            }
        } else {
            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) {
                    if (idx != -1) ans = Math.min(ans, i - idx);
                    idx = i;
                }
            }
        }
        return ans;
    }

}
