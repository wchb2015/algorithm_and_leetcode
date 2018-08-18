package com.wchb.leetcode;

/**
 * @date 7/23/18 1:36 PM
 */
public class S130 {

    private int m;
    private int n;

    public void solve(char[][] board) {

        m = board.length;
        if (m == 0) return;
        n = board[0].length;

        if (m < 3 || n < 3) return;

        fillBorders(board, 'O', 'Y');
        replace(board, 'O', 'X');
        fillBorders(board, 'Y', 'O');

    }


    private void fillBorders(char[][] board, char target, char c) {
        for (int i = 0; i < m; i++) {
            //第一列
            if (board[i][0] == target) fill(board, i, 0, target, c);
            // 最后一列
            if (board[i][n - 1] == target) fill(board, i, n - 1, target, c);
        }

        for (int j = 1; j < n - 1; j++) {
            //第一行
            if (board[0][j] == target) fill(board, 0, j, target, c);
            //最后一行
            if (board[m - 1][j] == target) fill(board, m - 1, j, target, c);
        }
    }

    private void fill(char[][] board, int i, int j, char target, char c) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != target) return;
        board[i][j] = c;
        fill(board, i - 1, j, target, c);
        fill(board, i + 1, j, target, c);
        fill(board, i, j - 1, target, c);
        fill(board, i, j + 1, target, c);
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
