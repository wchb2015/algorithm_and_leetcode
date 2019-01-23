package com.wchb.leetcode;

/**
 * @date 1/22/19 10:25 PM
 */
public class TicTacToe {
    char[][] board;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        board = new char[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        board[row][col] = player == 1 ? 'X' : 'O';

        //check row
        if (checkRow(row, player == 1 ? 'X' : 'O')) return player;
        //check column
        if (checkColumn(col, player == 1 ? 'X' : 'O')) return player;
        //check dial
        if (checkDial(player == 1 ? 'X' : 'O', row, col)) return player;
        return 0;
    }

    private boolean checkRow(int row, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != c) return false;
        }
        return true;
    }

    private boolean checkColumn(int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != c) return false;
        }
        return true;
    }

    private boolean checkDial(char ch, int r, int c) {
        //todo
//        int diff = r - c;
//        int sum = r + c;
//        boolean flag1 = true;
//        boolean flag2 = true;
//        int temp = 0;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//
//                if (i - j == diff) temp++;
//                if (i - j == diff && board[i][j] != ch) {
//                    flag1 = false;
//                }
//
//            }
//        }
//        if (temp == 1) flag1 = false;
//        temp = 0;
//        if (flag1) {
//            return true;
//        }
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (i + j == sum) temp++;
//                if (i + j == sum && board[i][j] != ch) {
//                    flag2 = false;
//                }
//            }
//        }
//        if (temp == 1) flag2 = false;
//        if (flag2) {
//            return true;
//        }
//
        return false;
    }
}
