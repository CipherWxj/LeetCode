package com.company.brush.dynamicProgramming;

import java.util.Arrays;

/**
 * @author: wangxinjian
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * <p>输入描述:
 * coins = [1, 2, 5], amount = 11
 * <p>输出描述:
 * 3
 * 解释：11 = 5 + 5 + 1
 */
public class CoinChange {
    private static int coinChange(int[] coins, int amount) {
        // 初始化动态数组，dp[i]表示金额为i时的最少硬币数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        // 对硬币数组进行排序，方便后续处理
        Arrays.sort(coins);
        for (int i = 1; i < amount + 1; i++) {
            // 初始化最小值为最大值减1，这里减1是为了避免溢出，方便后续取最小值
            int min = Integer.MAX_VALUE - 1;
            for (int coin : coins) {
                // 排序之后，如果当前金额减去硬币面值小于0，说明后边的硬币面值都大于当前所需金额，可以break
                if (i - coin < 0) break;
                min = Math.min(min, dp[i - coin]);
            }
            dp[i] = min + 1;
        }
        // 如果dp[amount]仍为最大值，说明无法凑成该金额，返回-1
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
