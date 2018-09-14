package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 7/18/18 10:50 AM
 */
public class S210 {


    // [0,1]:to take course 0 you have to first take course 1
    // edge[0] in
    // edge[1] out
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] ans = new int[numCourses];
        int idx = 0;
        int[] inDegree = new int[numCourses];
        int res = numCourses;
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                ans[idx++] = i;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int in = queue.poll();
            res--;
            for (int[] edge : prerequisites) {
                // remove that vertex and its outgoing edges
                // from the graph and repeat with the remaining graph.
                if (edge[1] == in) {
                    inDegree[edge[0]]--;
                    if (inDegree[edge[0]] == 0) {
                        ans[idx++] = edge[0];
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        return res == 0 ? ans : new int[]{};
    }

}
