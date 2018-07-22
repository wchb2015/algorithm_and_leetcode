package com.wchb.test;

/**
 * @date 7/21/18 1:34 PM
 */
public class ColorMap {

    private int NUM_ROWS = 4;
    private int RED = 1;
    private int BLUE = 4;
    private int[][] map = new int[NUM_ROWS][NUM_ROWS];

    //Try each of the four possible colors, and recur.
    //When you run out of countries, check whether you are at a goal node.
    boolean explore1(int row, int column, int color) {
        if (row >= NUM_ROWS) return mapIsOK();
        map[row][column] = color;
        for (int nextColor = RED; nextColor <= BLUE; nextColor++) {
            int[] next = nextRowAndColumn(row, column);
            if (explore1(next[0], next[1], nextColor)) return true;
        }
        return false;
    }

    //Used by both methods to find the next "country"
    //(actually, the row and column of the next square on the checkerboard).
    private int[] nextRowAndColumn(int row, int column) {
        return new int[0];
    }

    //Used by method 1 to check (at a leaf node) whether the entire map is colored correctly.
    private boolean mapIsOK() {
        return false;
    }

    //Try only those colors that have not already been used for an adjacent country, and recur.
    //If and when you run out of countries, you have successfully colored the map.
    boolean explore2(int row, int column, int color) {
        if (row >= NUM_ROWS) return true;
        if (okToColor(row, column, color)) {
            map[row][column] = color;
            for (int nextColor = RED; nextColor <= BLUE; nextColor++) {
                int[] next = nextRowAndColumn(row, column);
                if (explore2(next[0], next[1], nextColor)) return true;
            }
        }
        return false;
    }

    //Used by method 2 to check, at every node,
    //whether there is an adjacent node already colored with the given color.
    private boolean okToColor(int row, int column, int color) {
        return false;
    }

}
