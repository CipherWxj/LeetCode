/**
 * @author: Wxj
 * 463. 岛屿的周长
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
 * 网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>输入描述:
 * grid = [
 * [0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]
 * ]
 * <p>输出描述:
 * 16
 */
package com.company.brush.dfs;

import java.util.Scanner;

public class IslandPerimeter {
    public static int solution(int[][] grid) {
        int numRow = grid.length; // 行数
        int numColumn = grid[0].length; // 列数
        int count = 0;
        for (int row = 0; row < numRow; row++) {
            for (int column = 0; column < numColumn; column++) {
                if (grid[row][column] == 1) {
                    count += dfs(grid, row, column, numRow, numColumn); // 搜索
                }
            }
        }
        return count;
    }

    public static int dfs(int[][] grid, int row, int column, int numRow, int numColumn) {
        // 超过网格范围，陆地边缘
        if (row < 0 || row >= numRow || column < 0 || column >= numColumn) return 1;

        // 不是陆地，但是与陆地相邻
        if (grid[row][column] == 0) return 1;

        // 已经搜索过了
        if (grid[row][column] == 2) return 0;

        // 已经搜索过了，标记，防止重复遍历
        grid[row][column] = 2;

        // 向四周搜索
        int n = 0;
        n += dfs(grid, row - 1, column, numRow, numColumn);
        n += dfs(grid, row + 1, column, numRow, numColumn);
        n += dfs(grid, row, column - 1, numRow, numColumn);
        n += dfs(grid, row, column + 1, numRow, numColumn);

        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入网格行数 nr=");
        int nr = sc.nextInt();
        System.out.print("请输入网格列数 nc=");
        int nc = sc.nextInt();
        System.out.println("输入网格，每行按数组格式：");
        String none = sc.nextLine();
        int[][] grid = new int[nr][nc];
        for (int i = 0; i < nr; i++) {
            String s = sc.nextLine();
            s = s.substring(1, s.length() - 1);
            String[] str = s.split(",");
            for (int j = 0; j < nc; j++) {
                grid[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(solution(grid));
    }
}
