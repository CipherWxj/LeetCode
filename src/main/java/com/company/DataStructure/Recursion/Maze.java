package com.company.DataStructure.Recursion;

public class Maze {
    /**
     * 迷宫问题
     */
    public static void main(String[] args) {
        // 搭建迷宫
        int[][] maze = new int[8][8];
        // 设置围墙，1表示墙体
        for (int i = 0; i < 8; i++) {
            maze[0][i] = 1; // 上
            maze[7][i] = 1; // 下
            maze[i][0] = 1; // 左
            maze[i][7] = 1; // 右
        }
        // 设置障碍
        maze[3][1] = 1;
        maze[3][2] = 1;
        // 出口
        maze[7][6] = 0;

        // 显示迷宫
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                if (maze[j][k] == 1) {
                    System.out.print("[]");
                } else
                    System.out.print("  ");
            }
            System.out.println();
        }

        // 找路
        findWay(maze, 1, 1);

        // 显示路径
        System.out.println("路径找出口！！：");
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                if (maze[j][k] == 1) {
                    System.out.print("[]");
                } else if (maze[j][k] == 2 || maze[j][k] == 3) {
                    System.out.print("**");
                } else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static boolean findWay(int[][] map, int i, int j) {
        /**
         * 找路   找路策略：下>右>上>左
         * @param map 地图
         * @param i 起始位置横坐标
         * @param j 起始位置纵坐标
         * @return true:该点能走通
         */
        if (map[7][6] == 2) {
            return true;
        } else if (map[i][j] == 0) { // 如果当前这个点还没有走过
            // 按照策略 下>右>上>左
            map[i][j] = 2; // 标记走过的点
            if (findWay(map, i + 1, j)) { // 向下
                return true;
            } else if (findWay(map, i, j + 1)) { // 向右
                return true;
            } else if (findWay(map, i - 1, j)) { // 向上
                return true;
            } else if (findWay(map, i, j - 1)) { // 向左
                return true;
            } else {
                map[i][j] = 3; // 说明该点走不通，是死路
                return false;
            }
        } else { // 如果map[i][j]!=0, 可能是 1，2，3
            return false;
        }
    }
}
