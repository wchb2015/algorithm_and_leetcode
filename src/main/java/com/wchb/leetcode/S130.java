package com.wchb.leetcode;

/**
 * @date 7/23/18 1:36 PM
 */
public class S130 {

    private int[][] directions;
    private boolean[][] visited;


    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;
        directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        visited = new boolean[rows][cols];


    }


}
