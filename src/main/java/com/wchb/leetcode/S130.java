package com.wchb.leetcode;

/**
 * @date 7/23/18 1:36 PM
 */
public class S130 {

    private int m;
    private int n;

    //First dfs the '0' in the board, change it to '1';
    //Second liner scan 2d board, change '0' to 'X';
    //Finally liner scan 2d board, change '1' to '0';

    public void solve(char[][] board) {

        m = board.length;
        if (m == 0) return;
        n = board[0].length;

        for (int x = 0; x < m; x++) {
            //First col
            if (board[x][0] == 'O') {
                dfs(board, x, 0, 'O', '1');
            }
            //Last col
            if (board[x][n - 1] == 'O') {
                dfs(board, x, n - 1, 'O', '1');
            }
        }

        for (int y = 0; y < n; y++) {
            //First row
            if (board[0][y] == 'O') {
                dfs(board, 0, y, 'O', '1');
            }
            //Last row
            if (board[m - 1][y] == 'O') {
                dfs(board, m - 1, y, 'O', '1');
            }
        }

        replace(board, 'O', 'X');
        replace(board, '1', 'O');
    }


    private void dfs(char[][] board, int i, int j, char target, char c) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != target) return;
        board[i][j] = c;
        dfs(board, i - 1, j, target, c);
        dfs(board, i + 1, j, target, c);
        dfs(board, i, j - 1, target, c);
        dfs(board, i, j + 1, target, c);
    }

    private void replace(char[][] board, char target, char c) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target)
                    board[i][j] = c;
            }
        }
    }

}
