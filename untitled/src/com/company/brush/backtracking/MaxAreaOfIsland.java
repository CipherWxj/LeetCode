/**
 * @author: Wxj
 * 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的 1(代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>输入描述:
 * grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *         [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *         [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *         [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *         [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *         [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *         [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *         [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * <p>输出描述:
 * 6
 */
package com.company.brush.backtracking;

public class MaxAreaOfIsland {
    public int solution(int[][] grid){
        int max = 0;
        // 以每块区域为起始区向四周搜索
        // 由于沉岛操作，不用担心重复遍历

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j){
        // 终止条件：边界和水
        if (i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == 0) return 0;

        int count = 1;

        // 沉岛！！！遍历过了的岛屿沉掉，保证每个区域只遍历一次
        grid[i][j] = 0;

        // 向四周相邻区域递归
        count += dfs(grid, i - 1, j); // 上
        count += dfs(grid, i + 1, j); // 下
        count += dfs(grid, i, j - 1); // 左
        count += dfs(grid, i, j + 1); // 右
        return count;
    }
}
