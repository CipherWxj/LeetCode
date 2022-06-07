/**
 * @author: Wxj
 * 64. 最小路径和
 * 给定一个包含非负整数的 mxn 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * 1  3  1
 * 1  5  1
 * 4  2  1
 * <p>输出描述:
 * 7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
package com.company.brush.dynamicprogramming;

public class MinPathSum {

    public int solution(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 排除特殊情况，题目要求m、n为非负整数，所以样例中可能存在为0的情况
        if (grid == null || m == 0 || n == 0) return 0;
        // 动态数组
        int[][] dp = new int[m][n];
        // 初始边界条件
        dp[0][0] = grid[0][0];
        // 上边界
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 左边界
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        // 递推
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j][i] = Math.min(dp[j - 1][i], dp[j][i - 1]) + grid[j][i];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static String solutionSave(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 排除特殊情况，题目要求m、n为非负整数，所以样例中可能存在为0的情况
        if (grid == null || m == 0 || n == 0) return "";
        // 动态数组
        int[][] dp = new int[m][n];
        // 用于记录路径的可变字符串
        StringBuffer[][] path = new StringBuffer[m][n];
        // 初始边界条件
        dp[0][0] = grid[0][0];
        path[0][0] = new StringBuffer(String.valueOf(grid[0][0]));
        path[0][0].append("->");
        // 上边界
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            path[0][i] = new StringBuffer(path[0][i - 1]);
            path[0][i].append(grid[0][i]);
            path[0][i].append("->");
        }
        // 左边界
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
            path[j][0] = new StringBuffer(path[j - 1][0]);
            path[j][0].append(grid[j][0]);
            path[j][0].append("->");
        }
        // 递推
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[j - 1][i] < dp[j][i - 1]) {
                    dp[j][i] = dp[j - 1][i] + grid[j][i];
                    path[j][i] = new StringBuffer(path[j - 1][i]);
                    path[j][i].append(grid[j][i]);
                    path[j][i].append("->");
                } else {
                    dp[j][i] = dp[j][i - 1] + grid[j][i];
                    path[j][i] = new StringBuffer(path[j][i - 1]);
                    path[j][i].append(grid[j][i]);
                    path[j][i].append("->");
                }
            }
        }
        return path[m - 1][n - 1].substring(0, path[m - 1][n - 1].length() - 2);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solutionSave(grid));
    }
}
