package com.wchb.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @date 8/2/18 12:28 PM
 */
public class S73 {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> set = new HashSet<>();


        boolean hasZero;
        for (int x = 0; x < row; x++) {
            hasZero = false;
            for (int y = 0; y < col; y++) {
                if (matrix[x][y] == 0) {
                    hasZero = true;
                    set.add(y);
                }
            }
            if (hasZero) Arrays.fill(matrix[x], 0);
        }

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (set.contains(y)) matrix[x][y] = 0;
            }
        }

    }

}
