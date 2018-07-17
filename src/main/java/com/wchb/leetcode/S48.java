package com.wchb.leetcode;

/**
 * @date 7/16/18 10:47 PM
 */
public class S48 {
    public void rotate(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        //第一行变最后一列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //System.out.println(matrix[i][j]+"--"+i+":"+j);
                System.out.println(i + ":" + j + "-->" + j + ":" + (col - 1 - i));
                System.out.println(matrix[i][j] + "-->" + matrix[j][col - 1 - i]);
                swap(matrix, i, j, j, col - 1 - i);
            }

        }


        System.out.println("");

    }

    private void swap(int[][] matrix, int x, int y, int x1, int y1) {
        int temp = matrix[x][y];
        matrix[x][y] = matrix[x1][y1];
        matrix[x1][y1] = temp;
    }
}
