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

    //数组dp用来记录能凑出从 1 到 amount最少的硬币数量
    //dp[i]表示钱数为i时的最小硬币数的找零，递推式为：
    //dp[i] = min(dp[i], dp[i - coins[j]] + 1);
    //其中coins[j]为第j个硬币，而i - coins[j]为钱数i减去其中一个硬币的值，
    // 剩余的钱数在dp数组中找到值，然后加1和当前dp数组中的值做比较，
    // 取较小的那个更新dp数组。

    /************************************************************/

    public int coinChangeV2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) continue;

                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        // or

        for (int coin : coins) {
            for (int i = amount - coin; i >= 0; i--) {
                if (dp[i] != max) {
                    for (int k = 1; k * coin + i <= amount; k++) {
                        dp[i + k * coin] = Math.min(dp[i + k * coin], dp[i] + k);
                    }
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
