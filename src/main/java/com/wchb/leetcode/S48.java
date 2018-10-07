package com.wchb.leetcode;

/**
 * @date 7/16/18 10:47 PM
 */
public class S48 {

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */

    //先将上下翻转，再沿对角线翻转
    public void rotate(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        //reverse up to down

        int up = 0;
        int down = row - 1;

        while (up < down) {

            int[] temp = matrix[up];
            matrix[up] = matrix[down];
            matrix[down] = temp;

            up++;
            down--;
        }

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int x, int y, int x1, int y1) {
        int temp = matrix[x][y];
        matrix[x][y] = matrix[x1][y1];
        matrix[x1][y1] = temp;
    }

    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */


}
