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
        if (digits == null || digits.trim().length() == 0) return ret;
        dfs(digits, "");
        return ret;
    }

    private void dfs(String digits, String path) {
        if (digits.length() == 1) {
            for (char c : mapping[digits.charAt(0) - '0'].toCharArray()) {
                ret.add(path + c);
            }
        } else {
            for (char c : mapping[digits.charAt(0) - '0'].toCharArray()) {
                dfs(digits.substring(1), path + c);
            }
        }
    }
}
