/**
 * @author: Wxj
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>输入描述:
 * coins = [1, 2, 5], amount = 5
 * <p>输出描述:
 * 4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
package com.company.brush.dynamicprogramming;

public class CoinChange2 {
    public int solution(int[] coins, int amount) {
        // 动态数组，dp[i] 表示凑成金额为 i 的方式种数
        int[] dp = new int[amount + 1];

        // 初始条件（取不到也是一种方案）
        dp[0] = 1;
        // 依次遍历每一种硬币，控制取硬币的顺序，消除重复方案
        for (int coin : coins) {
            // 遍历每一个比所取硬币大的金额
            for (int i = coin; i < amount + 1; i++) {
                    // 在上一轮基础上再加上本轮的方案种数
                    dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}
