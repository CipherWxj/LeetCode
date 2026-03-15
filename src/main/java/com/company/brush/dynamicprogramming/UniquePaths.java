/**
 * @author: Wxj
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 问总共有多少条不同的路径？
 * <p>输入描述:
 * m = 3, n = 7
 * <p>输出描述:
 * 28
 */
package com.company.brush.dynamicprogramming;

public class UniquePaths {
    public int solution(int m, int n){
        int[][] dp = new int[m][n];
        // 边界条件
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 递推
        // 只有下移和右移两种方案，相加
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
