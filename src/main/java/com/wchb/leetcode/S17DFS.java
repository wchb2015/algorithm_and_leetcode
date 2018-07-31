package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/18/18 5:47 PM
 */

// DFS
public class S17DFS {

    String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",};
    List<String> ret = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return ret;

        dfs(digits, 0, new StringBuilder());
        return ret;
    }


    private void dfs(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            ret.add(sb.toString());
            return;
        }

        String chars = mapping[digits.charAt(index) - '0'];
        if (chars.length() == 0) return;
        char[] arr = chars.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(digits, index + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    /************************************************************/
    private void dfs(String digits, int index, String cur) {
        if (index == digits.length()) {
            ret.add(cur);
            return;
        }
        for (char c : mapping[digits.charAt(index) - '0'].toCharArray()) {
            dfs(digits, index + 1, cur + c);
        }
    }
}
