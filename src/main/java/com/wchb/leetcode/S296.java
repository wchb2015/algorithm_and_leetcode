package com.wchb.leetcode;


import java.util.Collections;
import java.util.LinkedList;

/**
 * @date 8/25/18 8:26 AM
 */
public class S296 {

    public int minTotalDistance(int[][] grid) {
        LinkedList<Integer> x = new LinkedList<>();
        LinkedList<Integer> y = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        int minDist = 0;
        minDist += getMin(x);
        minDist += getMin(y);

        return minDist;
    }

    private int getMin(LinkedList<Integer> list) {

        Collections.sort(list);
        int i = 0;
        int j = list.size() - 1;
        int dist = 0;
        while (i < j) {
            dist += list.get(j) - list.get(i);
            j--;
            i++;
        }

        return dist;
    }

}
