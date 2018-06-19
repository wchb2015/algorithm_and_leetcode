package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/18/18 9:51 AM
 */
public class S49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ret = new LinkedList();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sortedStr = sortStr(str);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                LinkedList<String> temp = new LinkedList<>();
                temp.add(str);
                map.put(sortedStr, temp);
            }
        }

        for (List<String> list : map.values()) {
            ret.add(list);
        }

        return ret;
    }

    private String sortStr(String str) {
        // convert input string to char array
        char tempArray[] = str.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }
}
