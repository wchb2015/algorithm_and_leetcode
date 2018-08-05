package com.wchb.leetcode;

/**
 * @date 8/4/18 8:00 AM
 */
public class S245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {

        int res = Integer.MAX_VALUE;

        int index1 = -1, index2 = -1, index = -1;
        boolean isEqual = word1.equals(word2);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.equals(word1)) {
                if (isEqual) {
                    if (index != -1) res = Math.min(res, i - index);
                } else {
                    if (index2 != -1) res = Math.min(res, i - index2);
                }
                index1 = i;
                index = i;
            } else if (word.equals(word2)) {
                if (isEqual) {
                    if (index != -1) res = Math.min(res, i - index);
                } else {
                    if (index1 != -1) res = Math.min(res, i - index1);
                }
                index2 = i;
                index = i;
            }

        }
        return res;
    }
}
