package com.wchb.mj.dreamG;

import java.util.Stack;

/**
 * @date 12/23/18 8:36 AM
 */

//https://www.youtube.com/watch?v=R4Nh-EgWjyQ
public class ConnectedCells {

    public int getBiggestRegion(int[][] matrix) {
        int maxRegion = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 1) {
                    int size = getRegionSize(matrix, row, column);
                    maxRegion = Math.max(size, maxRegion);
                }
            }
        }

        System.out.println(" ans: " + maxRegion);
        return maxRegion;
    }

    private int getRegionSize(int[][] matrix, int row, int column) {

        // boundary checks
        if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length) return 0;

        if (matrix[row][column] == 0) return 0;

        // the size of this region is going be one for  myself and plus the size of the region of
        // I traversed up,down,left,right,diagonal, so initial size is one. and then traverse

        int size = 1;
        matrix[row][column] = 0;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r == row && c == column) continue;
                size += getRegionSize(matrix, r, c);
            }
        }

        return size;
    }


    // using stack
    public int getBiggestRegionV2(int[][] matrix) {
        int maxRegion = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) continue;
                int size = getRegionSizeStack(matrix, r, c);
                maxRegion = Math.max(size, maxRegion);
            }
        }


        System.out.println(" ans: " + maxRegion);
        return maxRegion;
    }

    private int getRegionSizeStack(int[][] matrix, int r, int c) {
        // boundary checks
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length) return 0;
        int ans = 1;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(r, c));
        matrix[r][c] = 0;

        while (!stack.isEmpty()) {

            Point p = stack.pop();

            int x = p.row;
            int y = p.col;

            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length
                            || matrix[i][j] == 0) continue;
                    ans++;
                    stack.push(new Point(i, j));
                    matrix[i][j] = 0;
                }
            }
        }

        return ans;
    }

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
