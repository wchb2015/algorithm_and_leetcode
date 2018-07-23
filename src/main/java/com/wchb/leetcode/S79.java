package com.wchb.leetcode;

/**
 * @date 6/21/18 4:44 PM
 */
public class S79 {

    private int[][] directions;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        visited = new boolean[rows][cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (dfs(x, y, 0, board, word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int start, char[][] board, String word) {

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) return false;

        if (start == word.length() - 1) {
            return board[x][y] == word.charAt(start);
        }

        if (board[x][y] != word.charAt(start)) return false;

        for (int i = 0; i < directions.length; i++) {
            visited[x][y] = true;
            if (dfs(x + directions[i][0], y + directions[i][1], start + 1, board, word)) return true;
            visited[x][y] = false;
        }

        return false;
    }
}
