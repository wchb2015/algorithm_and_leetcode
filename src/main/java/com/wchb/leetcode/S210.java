package com.wchb.leetcode;

import com.wchb.course1.chapter2.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 7/18/18 10:50 AM
 */
public class S210 {

    // 0 unvisited 1 visiting 2 visited
    int[] visted;
    List<Integer>[] g;

    List<Integer> ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        init(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i)) return new int[]{};
        }

        int[] ret = new int[ans.size()];

        int i = 0;
        for (int j = ans.size() - 1; j >= 0; j--) {
            ret[i++] = ans.get(j);
        }
        return ret;
    }

    private void init(int numCourses, int[][] prerequisites) {
        visted = new int[numCourses];
        g = new List[numCourses];
        ans = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            g[edge[1]].add(edge[0]);
        }
    }

    // true 有环
    private boolean dfs(int v) {

        if (visted[v] == 1) return true;
        if (visted[v] == 2) return false;

        visted[v] = 1;
        for (Integer i : g[v]) {
            if (dfs(i)) return true;
        }

        visted[v] = 2;
        ans.add(v);

        return false;
    }
}
