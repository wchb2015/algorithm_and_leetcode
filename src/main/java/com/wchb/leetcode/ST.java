package com.wchb.leetcode;

import java.util.*;


/**
 * @date 12/29/18 12:27 PM
 */
public class ST {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        ret.add(Arrays.asList(i, map.get(str2rvs)));
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) {
                        ret.add(Arrays.asList(i, map.get(str1rvs)));

                    }
                }
            }
        }
        return ret;
    }

    private boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

}
