package com.wchb.leetcode;

/**
 * @date 7/16/18 10:47 PM
 */
public class S48 {

    //先将上下翻转，再沿对角线翻转
    public void rotate(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        //第一行变最后一列
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                swap(matrix, i, j, row - i - 1, j);
            }
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

    /************************************************************/

    public void rotateV2(int[][] matrix) {

        if (matrix.length == 0 || matrix.length != matrix[0].length) return;
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;


                //top   :matrix[first][i]
                //bottom:matrix[last][last - offset]

                //left  :matrix[last - offset][first]
                //right :matrix[i][last]

                int top = matrix[first][i];//save top
                //left->top
                matrix[first][i] = matrix[last - offset][first];
                //bottom->left
                matrix[last - offset][first] = matrix[last][last - offset];
                //right->bottom
                matrix[last][last - offset] = matrix[i][last];
                //top->right
                matrix[i][last] = top;
            }
        }

//        //原地坐标转换
//        for (int i = 0; i < height / 2; i++) {
//            for (int j = i; j < height - 1 - i; j++) {
//                temp = matrix[i][j];
//                matrix[i][j] = matrix[height - j - 1][i];
//                matrix[height - j - 1][i] = matrix[height - i - 1][height - j - 1];
//                matrix[height - i - 1][height - j - 1] = matrix[j][height - i - 1];
//                matrix[j][height - i - 1] = temp;
//            }
//        }
    }

}
