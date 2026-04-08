package com.company.brush.dynamicProgramming;

/**
 * @author: wangxinjian
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>输入描述:
 * n = 12
 * <p>输出描述:
 * 3
 */
public class NumSquares {
    private static int numSquares(int n) {
        // 初始化动态数组，dp[i]表示和为i的完全平方数的最少数量
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            // 如果有一个完全平方数j*j，那么和为i的完全平方数的最少数量等于和为i-j*j的完全平方数的最少数量加1
            // 枚举所有可能的j，得到满足最小次数的i-j*j
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
