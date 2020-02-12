package com.matthew.feng.leetcode;

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}

public class L489 {
    Robot robot;
    boolean[][] visited;

    void cleanRoom(int[][] room, int x, int y) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        visited = new boolean[room.length][room[0].length];
        int direction = 0;
        dfs(room, x, y, directions, direction);
    }

    private void dfs(int[][] room, int x, int y, int[][] directions, int direction) {
        visited[x][y] = true;
        robot.clean();
        for (int i = 0; i < directions.length; i++) {
            int nextX = x + directions[direction][0];
            int nextY = y + directions[direction][1];
            if (!visited[nextX][nextY] && room[nextX][nextY] == 1) {
                if (robot.move()) {
                    dfs(room, nextX, nextY, directions, direction);
                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }
            }
            robot.turnRight();
            direction = (direction + 1) % 4;
        }
    }
}
