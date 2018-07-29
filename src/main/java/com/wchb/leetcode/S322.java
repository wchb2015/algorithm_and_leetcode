package com.wchb.leetcode;

import java.util.Arrays;

/**
 * @date 7/25/18 9:17 PM
 */
public class S322 {

//    List<List<Integer>> ret;
//    int min = Integer.MAX_VALUE;
//
//
//    public int coinChange(int[] coins, int amount) {
//        ret = new LinkedList<>();
//
//        Integer[] integers = new Integer[coins.length];
//
//
//        for (int i = 0; i < coins.length; i++) integers[i] = coins[i];
//
//        Arrays.sort(integers, Collections.reverseOrder());
//
//        dfs(integers, 0, amount, new LinkedList<>());
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }
//
//    private void dfs(Integer[] candidates, int start, int target, LinkedList<Integer> path) {
//
//        if (target < 0 || path.size() >= min) {
//            return;
//        }
//
//        if (target == 0) {
//            System.out.println(path);
//            ret.add((List<Integer>) path.clone());
//            min = Math.min(min, path.size());
//            return;
//        }
//
//        for (int i = start; i < candidates.length; i++) {
//            if (candidates[i] > target) break;
//            path.add(candidates[i]);
//            dfs(candidates, i, target - candidates[i], path);
//            path.removeLast();
//        }
//
//    }
//
//    int minCost = Integer.MAX_VALUE;
//
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//
//        for (int i = 0; i < coins.length / 2; i++) {
//            int temp = coins[i];
//            coins[i] = coins[coins.length - i - 1];
//            coins[coins.length - i - 1] = temp;
//        }
//
//        return coinChange(0, coins, amount);
//    }
//
//    private int coinChange(int idxCoin, int[] coins, int amount) {
//        if (amount == 0) return 0;
//
//        if (idxCoin >= coins.length || amount < 0) return -1;
//
//        int maxVal = amount / coins[idxCoin];
//
//        if (maxVal == 0) return -1;
//
//        for (int x = maxVal; x > 0; x--) {
//            if (amount >= x * coins[idxCoin]) {
//                int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
//                if (res != -1) {
//                    minCost = Math.min(minCost, res + x);
//                }
//            }
//        }
//        return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
//    }

    /************************************************************/

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
