package com.wchb.leetcode;

import javafx.util.Pair;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 8/22/18 11:42 AM
 */
public class S675 {

    private int m;
    private int n;

    public int cutOffTree(List<List<Integer>> forest) {
        int ans = 0;
        m = forest.size();
        n = forest.get(0).size();


        LinkedList<Tree> trees = new LinkedList<>();

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (forest.get(x).get(y) > 1) {
                    trees.add(new Tree(x, y, forest.get(x).get(y)));
                }
            }
        }

        Collections.sort(trees, (t1, t2) -> t1.height - t2.height);


        int sx = 0;
        int sy = 0;
        for (int i = 0; i < trees.size(); i++) {
            int tx = trees.get(i).x;
            int ty = trees.get(i).y;

            int steps = bfs(forest, sx, sy, tx, ty);

            if (steps == -1) return -1;
            ans += steps;

            sx = tx;
            sy = ty;

        }

        return ans;
    }


    // min steps from startPoint(sx,sy) to EndPoint(tx,ty)
    // return -1 if unreachable
    private int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];


        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(sx, sy));
        int steps = 0;

        while (!queue.isEmpty()) {
            int newTrees = queue.size();

            while (newTrees > 0) {
                newTrees--;
                Pair<Integer, Integer> curTree = queue.remove();
                int cx = curTree.getKey();
                int cy = curTree.getValue();

                // Found the shortest path
                if (cx == tx && cy == ty) return steps;

                for (int i = 0; i < 4; i++) {
                    int x = cx + directions[i][0];
                    int y = cy + directions[i][1];


                    // Out of bound or un walkable
                    if (x < 0 || x >= m || y < 0 || y >= n || forest.get(x).get(y) == 0
                            || visited[x][y]) continue;

                    // Mark x, y as visited
                    visited[x][y] = true;
                    queue.add(new Pair<>(x, y));
                }
            }

            steps++;//BFS 按层处理,处理完一层 step++
        }

        // Impossible to reach
        return -1;
    }


    private class Tree {
        int x;
        int y;
        int height;

        public Tree(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
