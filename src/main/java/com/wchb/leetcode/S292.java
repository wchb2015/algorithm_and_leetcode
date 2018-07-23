package com.wchb.leetcode;

/**
 * @date 7/22/18 9:45 PM
 */
public class S292 {
    public boolean canWinNim(int n) {
        // 4個以下 赢
        if (n < 4) return true;
        // 4的倍數 输
        return n % 4 != 0;
    }
}
