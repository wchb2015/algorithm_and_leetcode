package com.wchb.leetcode;

/**
 * @date 1/29/19 10:34 PM
 */
public class S801 {
    int ans = Integer.MAX_VALUE;

    public int minSwap(int[] A, int[] B) {

        dfs(A, B, 0, 0);

        return ans;
    }

    private void dfs(int[] A, int[] B, int idx, int count) {
        if (count >= ans) return;
        if (idx == A.length) {
            ans = Math.min(count, ans);
            return;
        }
        if (idx == 0) {
            swap(A, B, 0);
            dfs(A, B, idx + 1, count + 1);
            swap(A, B, 0);

            dfs(A, B, idx + 1, count);


            return;
        }


        if (A[idx] > A[idx - 1] && B[idx] > B[idx - 1]) {
            dfs(A, B, idx + 1, count);
        }

        if (A[idx] > B[idx - 1] && B[idx] > A[idx - 1]) {
            swap(A, B, idx);
            dfs(A, B, idx + 1, count + 1);
            swap(A, B, idx);
        }
    }


    private void swap(int[] A, int[] B, int i) {
        int temp = B[i];
        B[i] = A[i];
        A[i] = temp;
    }
}
