package com.wchb.mj.dreamG;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 3/21/19 9:43 AM
 */
public class General {

    // 给出aa{b,c}dd，输出 aabdd aacdd，给出{aa,b}{c,dd}{e,g}，输出 "aace aacg aadde aaddg bce bcg bdde bdddg"
    public List<String> solution1(List<List<String>> list) {
        List<String> ans = new LinkedList<>();
        if (list.size() == 0) return ans;
        if (list.size() == 1) return list.get(0);
        dfs(list, 0, "", ans);
        return ans;
    }

    private void dfs(List<List<String>> list, int idx, String s, List<String> ans) {
        if (idx == list.size()) {
            ans.add(s);
            return;
        }

        for (String cur : list.get(idx)) {
            dfs(list, idx + 1, s + cur, ans);
        }
    }


    //A:abc，B：ababc = True，A：abc， B：acbdc = False.

    public boolean oneAdd(String from, String to) {

        String left = "";
        String right = "";
        int l = 0;

        int r = 0;

        while (l < from.length() && from.charAt(l) == to.charAt(l)) {
            l++;
        }
        if (l == from.length()) return true;

        while (r < from.length() && from.charAt(from.length() - 1 - r) == to.charAt(to.length() - 1 - r)) {
            r++;
        }
        if (r == from.length()) return true;

        left = to.substring(0, l + 1);
        right = to.substring(to.length() - r, to.length());


        return (left + right).equals(from);
    }

}
