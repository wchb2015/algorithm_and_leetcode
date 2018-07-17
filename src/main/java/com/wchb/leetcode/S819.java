package com.wchb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date 7/16/18 6:05 PM
 */
public class S819 {
    public String mostCommonWord(String paragraph, String[] banned) {

        String ret = "";
        paragraph += ".";
        int freq = -1;
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String s : banned) set.add(s);

        for (int i = 0; i < paragraph.length(); i++) {
            if (Character.isLetter(paragraph.charAt(i))) {
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else {
                if (sb.length() == 0 || set.contains(sb.toString())) {
                    sb = new StringBuilder();
                    continue;
                }
                System.out.println(sb.toString());
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                if (map.get(sb.toString()) > freq) {
                    freq = map.get(sb.toString());
                    ret = sb.toString();
                }
                sb = new StringBuilder();
            }
        }

        return ret;


    }

}
