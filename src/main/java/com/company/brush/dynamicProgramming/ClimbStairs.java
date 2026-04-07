package com.company.brush.dynamicProgramming;

/**
 * @author: wangxinjian
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>输入描述:
 * 2
 * <p>输出描述:
 * 2
 */
public class ClimbStairs {
    // 动态规划
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        // 初始化动态数组，dp[i]表示到达第i+1级台阶的方法数
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        // 要到达第n级台阶，要么从n-1级台阶走1步，要么从n-2级台阶走2步
        // 所以到达第i+1级台阶的方法数 等于 到达第i级台阶的方法数 加 到达第i-1级台阶的方法数
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int climbStairsPLus(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int dp1 = 1;
        int dp2 = 2;
        for (int i = 2; i < n; i++) {
            int dp3 = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp3;
        }
        return dp2;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }
}
