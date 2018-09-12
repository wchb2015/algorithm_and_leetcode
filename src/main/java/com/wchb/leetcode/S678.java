package com.wchb.leetcode;

/**
 * @date 7/26/18 8:09 PM
 */
public class S678 {

    //https://leetcode.com/problems/valid-parenthesis-string/discuss/107568/java-on2-memory-search

    public boolean checkValidString(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        return dfs(0, 0, s.toCharArray(), new int[s.length()][s.length() + 1]);
    }

    private boolean dfs(int idx, int cnt, char[] sArr, int[][] memo) {
        if (cnt < 0) return false;
        if (idx >= sArr.length) {
            return cnt == 0;
        }
        if (memo[idx][cnt] != 0) {
            return memo[idx][cnt] == 2; // 2 means valid 1 invalid
        }
        boolean ret = false;
        if (sArr[idx] == '(') {
            ret = dfs(idx + 1, cnt + 1, sArr, memo);
        } else if (sArr[idx] == ')') {
            ret = dfs(idx + 1, cnt - 1, sArr, memo);
        } else {
            ret = dfs(idx + 1, cnt, sArr, memo)
                    || dfs(idx + 1, cnt - 1, sArr, memo)
                    || dfs(idx + 1, cnt + 1, sArr, memo);
        }
        memo[idx][cnt] = ret ? 2 : 1;
        return ret;
    }

}
