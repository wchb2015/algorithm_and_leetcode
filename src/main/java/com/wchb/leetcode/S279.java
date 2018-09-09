package com.wchb.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @date 6/19/18 3:08 PM
 */
public class S279 {

    //逻辑正常,性能不行,推入大量重复元素
    public int numSquares(int n) {

        assert n > 0;

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.push(new Pair<>(n, 0));

        while (!queue.isEmpty()) {
            System.out.println(" Before: " + queue);
            int num = queue.peek().getKey();
            int step = queue.peek().getValue();
            queue.removeFirst();

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                queue.addLast(new Pair<>(num - i * i, step + 1));
            }
            System.out.println(" After: " + queue);
        }

        throw new IllegalArgumentException("No solution");
    }

    /************************************************************/

    public int numSquaresV2(int n) {

        assert n > 0;

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.push(new Pair<>(n, 0));

        while (!queue.isEmpty()) {

            int num = queue.peek().getKey();
            int step = queue.peek().getValue();
            queue.removeFirst();

            if (num == 0) {
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (!visited[a]) {
                    if (a == 0) return step + 1;
                    queue.addLast(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }

        throw new IllegalArgumentException("No solution");
    }

    /************************************************************/

    /**
     * 1. Definition:
     * - dp[i]: The least number of perfect square numbers of given integer i
     * <p>
     * 2. Answer:
     * - dp[n]
     * <p>
     * 3. State transfer equation
     * dp[i+j*j]  = min(dp[i]+1,dp[i+j*j]
     * 4. Initialization
     * dp[i*i] = 1;
     *
     * @param n
     * @return
     */

    public int numSquaresV3(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            if (i * i > n) break;
            dp[i * i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i + j * j > n) break;

                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }

        return dp[n];
    }
}
