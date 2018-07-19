package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 7/18/18 5:47 PM
 */

// DFS
public class S17DFS {

    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> ret = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.trim().length() == 0) {
            return ret;
        }
        dfs(digits, 0, "");
        return ret;
    }

    private void dfs(String digits, int index, String cur) {
        if (index == digits.length()) {
            ret.add(cur);
            return;
        }
        for (char c : mapping[Integer.parseInt(String.valueOf(digits.charAt(index)))].toCharArray()) {
//            cur += c;
//            System.out.println("before cur : " + cur);
//            dfs(digits, index + 1, cur);
//            cur = cur.substring(0, cur.length() - 1);
//            System.out.println("after cur : " + cur);

            dfs(digits, index + 1, cur + c);
        }
    }

}
