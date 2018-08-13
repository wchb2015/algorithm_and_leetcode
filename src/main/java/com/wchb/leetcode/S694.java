package com.wchb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 8/12/18 6:37 PM
 */
public class S694 {

    int m = 0;
    int n = 0;

    int[][] visited = null;
    StringBuilder sb = null;
    Set<String> set;

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        sb = new StringBuilder();
        set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    dfs(grid, i, j, sb);
                    set.add(sb.toString());
                    System.out.println(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        return set.size();
    }

    private void dfs(int[][] grid, int x, int y, StringBuilder sb) {
        if (!inArea(x, y) || visited[x][y] == 1 || grid[x][y] == 0) {
            return;
        }
        visited[x][y] = 1;
        dfs(grid, x + 1, y, sb.append("d"));
        dfs(grid, x - 1, y, sb.append("u"));
        dfs(grid, x, y + 1, sb.append("r"));
        dfs(grid, x, y - 1, sb.append("l"));
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
