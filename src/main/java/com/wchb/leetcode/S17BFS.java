package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/28/18 5:43 PM
 */
public class S17BFS {
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    LinkedList<String> ans = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return ans;
        }
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[digits.charAt(i) - '0'].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }

        System.out.println("  bfs: " + ans);
        return ans;
    }
}
