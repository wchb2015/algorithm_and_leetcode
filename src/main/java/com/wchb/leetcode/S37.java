package com.wchb.leetcode;

/**
 * @date 9/2/18 12:01 PM
 */
public class S37 {

    // Try 1 through 9 for each cell.
    // The time complexity should be 9 ^ m (m represents the number of blanks to be filled in),
    // since each blank can have 9 choices.
    // Details see comments inside code.
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell

                            if (solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; //check row
            if (board[row][i] != '.' && board[row][i] == c) return false; //check column


            for (int x = (row / 3) * 3; x < (row / 3 + 1) * 3; x++) {
                for (int y = (col / 3) * 3; y < (col / 3 + 1) * 3; y++) {
                    if (board[x][y] == c) {
                        return false;
                    }
                }
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
