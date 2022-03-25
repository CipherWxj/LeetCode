/**
 * @author: Wxj
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>输入描述:
 * grid = [
 * [1,1,0,0,0]
 * [1,1,0,0,0]
 * [0,0,1,0,0]
 * [0,0,0,1,1]
 * ]
 * <p>输出描述:
 * 3
 */
package com.company.brush.dfs;

import java.util.Scanner;

public class numOfIslands {
    public static int solution(char[][] grid) {
        int numRow = grid.length; // 行数
        int numColumn = grid[0].length; // 列数
        int count = 0;
        for (int row = 0; row < numRow; row++) {
            for (int column = 0; column < numColumn; column++) {
                if (grid[row][column] == '1') {
                    count++; // 计数
                    dfs(grid, row, column, numRow, numColumn); // 搜索
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int row, int column, int numRow, int numColumn) {
        // 超过范围返回
        if (row < 0 || row >= numRow || column < 0 || column >= numColumn) return;

        // 不是陆地，返回
        if (grid[row][column] != '1') return;

        // 已经搜索过了，标记，防止重复遍历
        grid[row][column] = '2';

        // 向四周搜索
        dfs(grid, row - 1, column, numRow, numColumn);
        dfs(grid, row + 1, column, numRow, numColumn);
        dfs(grid, row, column - 1, numRow, numColumn);
        dfs(grid, row, column + 1, numRow, numColumn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入网格行数 nr=");
        int nr = sc.nextInt();
        System.out.print("请输入网格列数 nc=");
        int nc = sc.nextInt();
        System.out.println("输入网格，每行按数组格式：");
        String none = sc.nextLine();
        char[][] grid = new char[nr][nc];
        for (int i = 0; i < nr; i++) {
            String s = sc.nextLine();
            s = s.substring(1, s.length() - 1);
            String[] str = s.split(",");
            for (int j = 0; j < nc; j++) {
                grid[i][j] = str[j].toCharArray()[0];
            }
        }
        System.out.println(solution(grid));
    }
}
