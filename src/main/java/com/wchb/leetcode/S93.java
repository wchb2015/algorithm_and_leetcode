package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/20/18 4:03 PM
 */
public class S93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return ret;
        dfs(s, 0, 0, "", ret);
        return ret;
    }

    private void dfs(String s, int index, int count, String addr, List<String> ret) {

        System.out.println(" index: " + index + " count: " + count + " addr: " + addr + " ret: " + ret);

        if (count > 4) {
            System.out.println("return-------- 啦!!!");
            return;
        }
        if (count == 4 && index == s.length()) {
            ret.add(addr);
            System.out.println("return+++++ 啦!!!");
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if ((temp.startsWith("0") && temp.length() > 1)
                    || (Integer.parseInt(temp) >= 256)) continue;

            dfs(s, index + i, count + 1, addr + temp + (count == 3 ? "" : "."), ret);
        }
    }

}
