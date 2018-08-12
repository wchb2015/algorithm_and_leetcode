package com.wchb.leetcode;

/**
 * @date 8/11/18 10:40 AM
 */
public class S240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        //find row first
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;

        for (int i = 0; i < row; i++) {
            if (!contains(matrix[i][0], matrix[i][col - 1], target)) continue;
            if (binarySearch(matrix[i], target)) return true;
        }

        return false;
    }


    private boolean contains(int min, int max, int target) {
        return target >= min && target <= max;
    }

    private boolean binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid] > target) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
