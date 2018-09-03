package com.wchb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date 8/20/18 12:38 PM
 */
public class S36 {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cube = new HashSet<>();

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;


                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);

                if (board[rowIndex + j / 3][colIndex + j % 3] != '.'
                        && !cube.add(board[rowIndex + j / 3][colIndex + j % 3]))
                    return false;
            }
        }


        return true;
    }

    public boolean isValidSudokuV2(char[][] board) {

        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            Set<Character> cube = new HashSet<>();
            map.put(i, cube);
        }

        for (int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;
                if (board[i][j] != '.' && !map.get(3 * (i / 3) + j / 3).add(board[i][j])) return false;
            }
        }

        return true;
    }
}
