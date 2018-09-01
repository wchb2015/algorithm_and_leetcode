package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 8/31/18 1:47 PM
 */
public class S417V2 {
    private int m, n;
    private boolean[][] pacific, atlantic;
    private int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {

        ArrayList<int[]> res = new ArrayList<>();
        m = matrix.length;
        if (m == 0) return res;
        n = matrix[0].length;

        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, atlantic, i, 0);
            dfs(matrix, pacific, i, n - 1);

        }

        for (int j = 0; j < n; j++) {
            dfs(matrix, atlantic, 0, j);
            dfs(matrix, pacific, m - 1, j);

        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && matrix[newX][newY] >= matrix[x][y])
                dfs(matrix, visited, newX, newY);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
