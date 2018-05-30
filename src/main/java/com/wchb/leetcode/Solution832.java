package com.wchb.leetcode;

public class Solution832 {


    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = flipAndInvertArray(A[i]);
        }
        return A;
    }

    public int[] flipAndInvertArray(int[] a) {
        int[] ret = new int[a.length];
        if (a.length == 0) {
            return ret;
        }
        for (int i = 0; i < a.length; i++) {
            ret[i] = a[a.length - 1 - i] == 0 ? 1 : 0;
        }
        return ret;
    }

    public int[][] flipAndInvertImage2(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
}
