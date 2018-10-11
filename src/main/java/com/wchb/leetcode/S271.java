package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/13/18 3:19 PM
 */
public class S271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        if (strs == null) return null;
        if (strs.size() == 0) return "";


        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null) return null;
        List<String> ans = new LinkedList<>();
        if (s.equals("")) return ans;

        int numStart = 0;
        while (true) {
            int idx = s.indexOf("#", numStart);

            if (idx == -1) break;

            int len = Integer.parseInt(s.substring(numStart, idx));
            if (len == 0) {
                ans.add("");
            } else {
                String curStr = s.substring(idx + 1, idx + 1 + len);
                ans.add(curStr);
            }

            numStart = (idx + len + 1);
        }

        return ans;
    }
}
