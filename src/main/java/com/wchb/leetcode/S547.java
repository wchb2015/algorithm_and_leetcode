package com.wchb.leetcode;

import com.wchb.course1.chapter11.UnionFind6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.TreeSet;

/**
 * @date 6/7/18 1:54 PM
 */
public class S547 {

    private static final Logger logger = LoggerFactory.getLogger(S547.class);

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind6 uf = new UnionFind6(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                logger.info("i:{},j:{}", i, j);
                if (M[i][j] == 1) {
                    uf.unionElements(i, j);
                }
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(uf.find(i));
        }
        return set.size();
    }

    public int findCircleNumV3(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        int trackId = new Random().nextInt(1000) + 1000;
        System.out.println(trackId + " dfs : " + i);
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                System.out.println(trackId + " dfs : " + j);
                dfs(M, visited, j);
            }
        }
    }


}
