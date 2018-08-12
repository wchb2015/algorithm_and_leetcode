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
        LinkedList<Integer> list = new LinkedList<>();

        int len = s.length();

        if (len <= 1) {
            list.add(len);
            return list;
        }

        // key: Character in S.
        // value: index of key where key occurs last
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0; i < len; ) {
            int last = map.get(s.charAt(i));
            int j = i + 1;
            while (j <= last) {
                last = Math.max(last, map.get(s.charAt(j)));
                j++;
            }
            list.add(last - i + 1);
            i = last + 1;
        }

        return list;
    }
}
