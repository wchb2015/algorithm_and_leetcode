package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/20/18 4:03 PM
 */
public class S93 {
    List<String> ret;

    public List<String> restoreIpAddresses(String s) {
        ret = new LinkedList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return ret;
        dfs(s, 0, 0, "");
        return ret;
    }

    private void dfs(String s, int index, int count, String addr) {

        if (count == 4 && index == s.length()) {
            ret.add(addr);
            return;
        }

        int i = 0;
        while (i <= 3) {
            i++;
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if ((temp.startsWith("0") && temp.length() > 1)
                    || (Integer.parseInt(temp) >= 256)) {
                continue;
            }
            if (count == 3 && index + i != s.length()) {
                continue;
            }
            dfs(s, index + i, count + 1, addr + temp + (count == 3 ? "" : "."));
        }
    }
}
