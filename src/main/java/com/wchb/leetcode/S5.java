package com.wchb.leetcode;

/**
 * @date 8/24/18 2:16 PM
 */
public class S5 {

    //http://windliang.cc/2018/08/05/leetCode-5-Longest-Palindromic-Substring/

    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }

    /************************************************************/
    public String longestPalindromeV2(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) &&
                        (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /************************************************************/
    // 中心发散
    public String longestPalindromeV3(String s) {
        int max = -1;
        String ans = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int l = i - 1;
            int len = 1;
            while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                len++;
                i++;
            }
            if (len > max) {
                max = len;
                ans = s.substring(l + 1, i + 1);
            }
            int r = i + 1;

            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        ans = s.substring(l, r + 1);
                    }
                    r++;
                    l--;
                } else {
                    break;
                }
            }
        }


        return ans;
    }

}
