/**
 * @author: Wxj
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>输入描述:
 * 2
 * <p>输出描述:
 * 2
 */
package com.company.brush;

import java.util.Scanner;

public class ClimbStairs {
    // 动态规划
    public static int solution(int n) {
        if (n == 1) return 1; // 1级台阶，方案数：1
        if (n == 2) return 2; // 2级台阶，方案数：2

        // 初始化数组记录方案数，dp[0]空出，不做操作
        int[] dp = new int[n + 1];

        // 初始化边界条件
        dp[1] = 1; // 1级台阶，方案数：1
        dp[2] = 2; // 2级台阶，方案数：2

        // 递推
        for (int i = 3; i <= n; i++) {
            // 每次能走的台阶数只能是         走1级或者                    走2级
            // 因此到达第i级台阶的方案数dp[i]=到达第i-1级台阶的方案数dp[i-1]+到达第i-2级台阶的方案数dp[i-2]
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
