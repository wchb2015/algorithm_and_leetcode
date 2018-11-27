package com.wchb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 11/26/18 5:10 PM
 */
public class S489 {


//    我是dfs，用一个set记录visited。设定起点是原点，
//    dfs helper函数要传机器人当前方向，用0123表示就可以。
//    每一个helper函数用for循环走四次。每一次按照顺时针或者逆时针转一下。
//    把走过的坐标和cannot move的点都放进visited。
//    最重要的是走完发现无路可走之后 要再转向后方走一步再转向后，
//    也就是返回上级helper函数时机器人所在的位置和面朝的方向。

    final int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, visited, 0, 0);
    }


    private void dfs(Robot robot, Set<String> visited, int startRow, int startCol) {

        String node = startRow + "," + startCol;
        if (visited.contains(node)) return;
        visited.add(node);
        robot.clean();

        for (int i = 0; i < 4; i++) {

            robot.turnRight();

            int newRow = startRow + directions[i][0];
            int newCol = startCol + directions[i][1];
            visited.add(newRow + "," + newCol);

            if (robot.move()) {
                dfs(robot, visited, newRow, newCol);
            } else {
                robot.turnLeft();
            }
        }
    }
}


interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();

}