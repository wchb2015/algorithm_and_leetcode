package com.wchb.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date 6/7/18 3:29 PM
 */
public class S547V2 {

    int tree[] = new int[200];

    private static final Logger logger = LoggerFactory.getLogger(S547V2.class);


    public int findCircleNum(int[][] M) {
        int len = M[0].length;
        for (int i = 0; i < len; i++) {
            tree[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    int aRoot = findRoot(i);
                    int bRoot = findRoot(j);
                    if (aRoot != bRoot) {
                        logger.info("aRoot:{},bRoot:{}", aRoot, bRoot);
                        tree[aRoot] = bRoot;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (tree[i] == -1) {
                ans++;
            }
        }
        return ans;
    }

    public int findRoot(int x) {
        logger.info("x:{},tree[x]:{}", x, tree[x]);
        if (tree[x] == -1) {
            return x;
        } else {
            int temp = findRoot(tree[x]);
            tree[x] = temp;
            return temp;
        }
    }
}
