package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/25/18 9:17 PM
 */
public class S322 {

    int ret = Integer.MAX_VALUE;

    //DFS
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        for (int i = 0; i < coins.length / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - i - 1];
            coins[coins.length - i - 1] = temp;
        }

        coinChange(coins, 0, amount, 0);

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    private void coinChange(int[] coins, int index, int amount, int count) {

        int curCoin = coins[index];
        if (index == coins.length - 1) {
            if (amount % curCoin == 0) {
                ret = Math.min(ret, count + amount / curCoin);
            }
        } else {
            for (int k = amount / curCoin; k >= 0 && count + k < ret; k--) {
                coinChange(coins, index + 1, amount - k * curCoin, count + k);
            }
        }
    }

}
