package com.wchb.leetcode;

import java.util.*;


/**
 * @date 12/29/18 12:27 PM
 */
public class ST {
    public int distributeCoins(TreeNode root) {
        Map<TreeNode, List<TreeNode>> g = new HashMap<>();


        return 1;
    }


    int r;
    int c;
    int ans;
    int[] start;
    int[] end;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int uniquePathsIII(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        ans = 0;

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (grid[x][y] == 1) {
                    start = new int[]{x, y};
                }
                if (grid[x][y] == 2) {
                    end = new int[]{x, y};
                }
            }
        }

        boolean[][] visited = new boolean[r][c];
        visited[start[0]][start[1]] = true;
        dfs(grid, start[0], start[1], visited);
        return ans;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (x == end[0] && y == end[1] && allVisited(visited, grid)) {
            ans++;
            return;
        }

        for (int[] dir : dirs) {
            int nr = x + dir[0];
            int nc = y + dir[1];
            if (!isValid(nr, nc, grid) || grid[nr][nc] == -1 || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(grid, nr, nc, visited);
            visited[nr][nc] = false;
        }
    }

    private boolean allVisited(boolean[][] visited, int[][] grid) {
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (!visited[x][y] && grid[x][y] == 0) {
                    if (x == start[0] && y == start[1]) continue;
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isValid(int r, int c, int[][] image) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return false;
        }
        return true;
    }


}
