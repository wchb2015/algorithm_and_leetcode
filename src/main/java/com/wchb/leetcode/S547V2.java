package com.wchb.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @date 6/7/18 3:29 PM
 */
public class S547V2 {

    int[] parent;

    public int findCircleNum(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        Set<Integer> ans = new HashSet<>();
        parent = new int[m];

        Arrays.fill(parent, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) ans.add(find(i));

        return ans.size();
    }

    private void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }

        for (int i = 0; i < parent.length; i++) {
            if (find(i) == pId) {
                parent[i] = qId;
            }
        }
    }


    private int find(int i) {
        return parent[i] == -1 ? i : parent[i];
    }
}
