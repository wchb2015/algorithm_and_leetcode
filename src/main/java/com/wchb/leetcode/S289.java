package com.wchb.leetcode;

/**
 * @date 8/20/18 2:42 PM
 */
public class S289 {
    private int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 1}};
    int m = 0;
    int n = 0;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNumOfLive(board, i, j);
                if (count == 3 || (count == 2 && board[i][j] == 1)) board[i][j] += 10;
            }
        }

        flashBoard(board);
    }


    private void flashBoard(int[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] / 10;
            }
        }
    }


    private int countNumOfLive(int[][] board, int i, int j) {

        int numOfLive = 0;

        for (int[] d : dirs) {
            if (isValid(i + d[0], j + d[1])) {
                numOfLive += board[i + d[0]][j + d[1]] % 10;
            }

        }


        return numOfLive;
    }


    private boolean isValid(int i, int j) {
        boolean ret = i >= 0 && i < m && j >= 0 && j < n;
        return ret;
    }
}
