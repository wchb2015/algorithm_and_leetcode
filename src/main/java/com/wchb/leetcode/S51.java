package com.wchb.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 6/21/18 9:29 PM
 */
public class S51 {

    List<List<String>> ret;
    boolean[] col;
    boolean[] dia1;//x+y
    boolean[] dia2;//x-y


    public List<List<String>> solveNQueens(int n) {
        ret = new LinkedList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        put(n, 0, new LinkedList<>());

        return ret;
    }

    // 尝试在一个n皇后问题中, 摆放第x行的皇后位置
    private void put(int n, int x, LinkedList<Integer> path) {

        if (x == n) {
            ret.add(generateBoard(n, path));
            return;
        }

        for (int y = 0; y < n; y++) {
            if (col[y] || dia1[x + y] || dia2[x - y + (n - 1)]) continue;
            path.add(y);
            col[y] = true;
            dia1[x + y] = true;
            dia2[x - y + (n - 1)] = true;
            put(n, x + 1, path);
            col[y] = false;
            dia1[x + y] = false;
            dia2[x - y + (n - 1)] = false;
            path.removeLast();
        }

    }

    private List<String> generateBoard(int n, LinkedList<Integer> path) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[path.get(i)] = 'Q';
            ans.add(new String(arr));
        }
        return ans;
    }

}
