package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 7/18/18 10:50 AM
 */
public class S210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] ans = new int[numCourses];
        int idx = 0;
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                ans[idx++] = i;
            }
        }

        while (!q.isEmpty()) {

            int in = q.poll();
            for (int[] edge : prerequisites) {
                if (edge[1] == in) {
                    inDegree[edge[0]]--;
                    if (inDegree[edge[0]] == 0) {
                        q.offer(edge[0]);
                        ans[idx++] = edge[0];
                    }
                }

            }
        }


        return idx == numCourses ? ans : new int[]{};

    }
}
