package com.wchb.leetcode;

import java.util.*;


/**
 * @date 12/29/18 12:27 PM
 */
public class ST {
    int ans;

    public int largestPerimeter(int[] A) {
        ans = 0;
        int n = A.length;
        if (n < 2) return ans;
        Arrays.sort(A);

        boolean[] used = new boolean[n];

        dfs(A, used, new LinkedList<>());

        return ans;
    }

    private void dfs(int[] A, boolean[] used, List<Integer> path) {
        if (path.size() == 3) {
            if (canForm(path)) {
                ans = Math.max(ans, path.get(0) + path.get(1) + path.get(2));
            }
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (used[i]) continue;
            path.add(A[i]);
            used[i] = true;
            dfs(A, used, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    private boolean canForm(List<Integer> path) {
        int a = path.get(0);
        int b = path.get(1);
        int c = path.get(2);
        return a + b > c && a + c > b && b + c > a;
    }
}
