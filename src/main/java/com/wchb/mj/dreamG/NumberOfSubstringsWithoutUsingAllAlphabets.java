package com.wchb.mj.dreamG;

import java.util.*;

/**
 * @date 12/1/18 4:16 PM
 */
public class NumberOfSubstringsWithoutUsingAllAlphabets {

    public List<String> solution(String s, char[] arr) {

        int left = 0;
        int right = 0;
        LinkedList<String> ans = new LinkedList<>();

        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) set.add(c);

        while (right < s.length()) {

            if (set.contains(s.charAt(right))) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (map.size() == set.size()) {
                if (!map.containsKey(s.charAt(left))) {
                    left++;
                    continue;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }


            ans.add(s.substring(left, right + 1));
            right++;
        }

        return ans;
    }
}
