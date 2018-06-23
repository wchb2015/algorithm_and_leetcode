package com.wchb.leetcode;

/**
 * @date 6/21/18 6:13 PM
 */
public class S200 {

    //向4个方向移动的位移 上右下左
    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    private boolean[][] visited;

    private int sum;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    sum++;
                    dfs(grid, i, j);
                }
            }
        }

        return sum;
    }


    //从grid[x][y]位置开始,进行flood fill算法
    //保证(x,y)合法,且grid[x][y]是没有被访问过得陆地
    private void dfs(char[][] grid, int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];

            if (inArea(newX, newY) && !visited[newX][newY]
                    && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }

        return;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
