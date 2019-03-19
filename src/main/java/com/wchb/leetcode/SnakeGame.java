package com.wchb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 3/18/19 9:35 PM
 */
public class SnakeGame {

    int[][] board;
    int length;
    List<int[]> foodList;
    int[] curFood;
    boolean done;
    LinkedList<int[]> snake;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        board = new int[height][width];
        foodList = new LinkedList<>();
        length = 0;
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        for (int i = 0; i < food.length; i++) {
            foodList.add(food[i]);
        }

        if (foodList.size() > 0) {
            curFood = foodList.remove(0);
        } else {
            curFood = new int[]{-1, -1};
        }
        done = false;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        if (done) return -1;

        int nr = snake.getFirst()[0];
        int nc = snake.getFirst()[1];
        if (direction.equals("U")) {
            nr--;
            if (nr < 0) {
                done = true;
                return -1;

            }
        } else if (direction.equals("D")) {
            nr++;
            if (nr >= board.length) {
                done = true;
                return -1;
            }
        } else if (direction.equals("L")) {
            nc--;
            if (nc < 0) {
                done = true;
                return -1;
            }
        } else if (direction.equals("R")) {
            nc++;
            if (nc >= board[0].length) {
                done = true;
                return -1;
            }
        }


        boolean flag = false;
        int[] nextPos = new int[]{nr, nc};
        if (nr == curFood[0] && nc == curFood[1]) {
            flag = true;
            length++;
            increase(snake, nextPos);
            if (foodList.size() > 0) {
                curFood = foodList.remove(0);
            }
        }

        if (!flag) {
            if (changeAndCheck(snake, new int[]{nr, nc})) {
                done = true;
                return -1;
            }
        }

        return length;
    }


    private boolean changeAndCheck(LinkedList<int[]> snake, int[] newPos) {
        snake.removeLast();
        snake.addFirst(newPos);

        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(i)[0] == newPos[0] && snake.get(i)[1] == newPos[1]) return true;
        }

        return false;
    }

    private void increase(LinkedList<int[]> snake, int[] newPos) {
        snake.addFirst(newPos);
    }
}
