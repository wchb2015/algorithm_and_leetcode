package com.wchb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 8/20/18 12:38 PM
 */
public class S36 {

    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] cubes = new Set[9];
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];

        for (int i = 0; i < 9; i++) {
            cubes[i] = new HashSet<>();
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char cur = board[row][col];
                int key = 3 * (row / 3) + col / 3;
                if (cur == '.') continue;
                if (rows[row].contains(cur) ||
                        cols[col].contains(cur) ||
                        cubes[key].contains(cur))
                    return false;

                // update rows,cols,map for future iteration
                rows[row].add(cur);
                cols[col].add(cur);
                cubes[key].add(cur);
            }
        }

        return true;
    }
}
