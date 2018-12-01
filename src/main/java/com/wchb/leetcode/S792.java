package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 11/30/18 5:45 PM
 */
public class S792 {
    public int numMatchingSubseq(String s, String[] words) {

        int ans = 0;
        // key: characters in s, value: corresponding index of characters.
        Map<Character, ArrayList> map = new HashMap<>();

        // build map
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), new ArrayList());
            map.get(s.charAt(i)).add(i);
        }

        for (String word : words) {
            if (isMatch(word, map)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isMatch(String word, Map<Character, ArrayList> map) {

        int lastIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            ArrayList<Integer> indexs = map.get(word.charAt(i));
            if (indexs.size() == 0) return false;

            for (int j = 0; j < indexs.size(); j++) {
                if (indexs.get(j) <= lastIndex) continue;
                lastIndex = indexs.get(j);
                break;
            }
            if (lastIndex >= word.length()) return false;
        }


        return lastIndex == word.length() - 1;
    }
}
