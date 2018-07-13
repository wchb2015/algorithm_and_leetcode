package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/12/18 6:44 PM
 */
public class S151 {
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return s == null ? s : s.trim();
        }

        String[] arr = s.split(" ");

        List<String> list = new LinkedList();

        for (String str : arr) {
            if (str.trim().length() == 0) {
                continue;
            }
            list.add(str);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }

        return sb.toString().trim();
    }
}
