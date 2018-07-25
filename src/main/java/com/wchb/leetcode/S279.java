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
    //https://leetcode.com/problems/perfect-squares/discuss/71495/an-easy-understanding-dp-solution-in-java
    public int numSquaresV3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
