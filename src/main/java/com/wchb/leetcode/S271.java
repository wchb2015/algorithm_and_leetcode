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
        if (s.equals("")) return new LinkedList<>();

        List<String> ret = new LinkedList<>();

        int index = 0, start = 0;
        while (true) {
            index = s.indexOf("#", index);
            if (index == -1) {
                break;
            }
            int length = Integer.parseInt(s.substring(start, index));

            ret.add(length == 0 ? "" : s.substring(index + 1, index + 1 + length));

            index += (length + 1);
            start = index;
        }

        return ret;

    }
}
