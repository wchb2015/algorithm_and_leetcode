package com.wchb.leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @date 8/11/18 9:57 AM
 */
public class S763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new LinkedList<>();

        int len = s.length();
        int[] last = new int[26];

        for (int i = 0; i < len; i++) last[s.charAt(i) - 'a'] = i;


        for (int i = 0; i < len; ) {
            int lastIdx = last[s.charAt(i) - 'a'];
            int j = i + 1;

            while (j <= lastIdx) {
                lastIdx = Math.max(lastIdx, last[s.charAt(j) - 'a']);
                j++;
            }
            ans.add(lastIdx - i + 1);
            i = lastIdx + 1;
        }

        return ans;
    }
}
