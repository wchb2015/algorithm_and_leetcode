package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @date 7/11/18 1:42 PM
 */
public class S200 {

    int m = 0;
    int n = 0;

    int[][] visited = null;

    // dfs
    public int numIslandsV1(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (!inArea(x, y) || visited[x][y] == 1 || grid[x][y] == '0') {
            return;
        }
        visited[x][y] = 1;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    /**********************************************************/

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // stack
    public int numIslandsV2(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        if (cols == 0) return 0;

        Stack<Point> stack = new Stack<>();

        int ans = 0;

        // When finding a new '1', add this coordinate to the stack and jump out of loop;
        // After searching all the 4 directions and doesn't find '1', pop out current element in the stack;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    ans++;
                    stack.push(new Point(r, c));
                    grid[r][c] = '0';
                    while (!stack.empty()) {
                        Point p = stack.pop();
                        for (int k = 0; k < 4; k++) {
                            int nextR = p.row + dirs[k][0];
                            int nextC = p.col + dirs[k][1];
                            if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols || grid[nextR][nextC] == '0') {
                                continue;
                            }
                            stack.push(new Point(nextR, nextC));
                            grid[nextR][nextC] = '0';
                        }
                    }
                }
            }
        }


        return ans;
    }

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**********************************************************/
    // bfs
    public int numIslandsV3(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void bfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));

        while (!q.isEmpty()) {
            Point p = q.poll();

            int r = p.row;
            int c = p.col;

            if (r > 0 && grid[r - 1][c] == '1') {
                q.add(new Point(r - 1, c));
                grid[r - 1][c] = '0';
            }

            if (r < n - 1 && grid[r + 1][c] == '1') {
                q.add(new Point(r + 1, c));
                grid[r + 1][c] = '0';
            }

            if (c > 0 && grid[r][c - 1] == '1') {
                q.add(new Point(r, c - 1));
                grid[r][c - 1] = '0';
            }
            if (c < n - 1 && grid[r][c + 1] == '1') {
                q.add(new Point(r, c + 1));
                grid[r][c + 1] = '0';
            }
        }
    }
}
