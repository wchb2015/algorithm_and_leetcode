package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 8/31/18 1:13 PM
 */
public class S417 {
    int m, n;
    List<int[]> ans;
    int[][] dirs;

    boolean[][] p;
    boolean[][] a;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        ans = new LinkedList<>();
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        p = new boolean[m][n];
        a = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j);
                dfs(matrix, i, j);
            }
        }

        return ans;
    }


    private boolean dfs(int[][] matrix, int x, int y) {
        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
