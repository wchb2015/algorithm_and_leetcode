package com.wchb.mj.any;

import java.util.Scanner;

/**
 * @date 2/18/19 7:41 PM
 */
public class TTT {

    private char[][] board;
    private int ROWS = 3;
    private int COLS = 3;
    private char EMPTY = ' ';


    public void initializeBoard() {
        board = new char[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }


    public void setBoard(int x, int y, char c) {
        board[x][y] = c;
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                sb.append(board[i][j]).append("|");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }


}
