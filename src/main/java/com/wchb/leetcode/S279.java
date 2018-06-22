package com.wchb.leetcode;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * @date 6/19/18 3:08 PM
 */
public class S279 {

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

    //逻辑正常,性能不行,推入大量重复元素
    public int numSquares(int n) {

        assert n > 0;

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
                queue.addLast(new Pair<>(num - i * i, step + 1));
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}
