package com.wchb.leetcode;

/**
 * @date 7/23/18 3:05 PM
 */
public class S52 {

    int ret;
    boolean[] col;
    boolean[] dia1;//x+y
    boolean[] dia2;//x-y

    public int totalNQueens(int n) {
        ret = 0;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        put(n, 0);

        return ret;
    }

    // 尝试在一个n皇后问题中, 摆放第x行的皇后位置
    private void put(int n, int x) {

        if (x == n) {
            ret++;
            return;
        }

        for (int y = 0; y < n; y++) {
            if (col[y] || dia1[x + y] || dia2[x - y + (n - 1)]) continue;
            col[y] = true;
            dia1[x + y] = true;
            dia2[x - y + (n - 1)] = true;
            put(n, x + 1);
            col[y] = false;
            dia1[x + y] = false;
            dia2[x - y + (n - 1)] = false;

        }
    }
}
