package com.wchb.leetcode;

public class Solution832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row : A) {
            for (int i = 0; i < C / 2; i++) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
            if (row.length % 2 == 1) {
                row[row.length / 2] ^= 1;
            }
        }
        return A;
    }

}
