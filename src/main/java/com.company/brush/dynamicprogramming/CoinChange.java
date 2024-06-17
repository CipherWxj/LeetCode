/**
 * @author: Wxj
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
package com.company.brush.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public int solution1(int[] coins, int amount) {
        // 动态数组
        int[] dp = new int[amount + 1];
        // 动态数组初始化，初始值都赋成一个不可能的值
        Arrays.fill(dp, amount + 1);
        // 初始条件
        dp[0] = 0;
        // 迭代每一个比 amount 小的金额，直到 amount 结束
        for(int i = 0; i < amount + 1; i++){
            // 查询每一个硬币面额
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    // 金额更新，递归
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // 声明全局数组，保存已经计算过的金额所需次数
    int[] memory;
    public int solution2(int[] coins, int amount) {
        // 数组的初始化要在函数中，根据amount确定长度
        memory = new int[amount + 1];
        return search(coins, amount);
    }

    public int search(int[] coins, int amount){
        // 终止条件
        // 没有符合的硬币面额
        if(amount < 0) return -1;
        // 硬币面额恰好换算完
        if(amount == 0) return 0;
        // 已经有保存的金额所需次数
        if(memory[amount] != 0) return memory[amount];

        // 赋一个不可能的初值
        int min = amount + 1;
        for(int i = 0; i < coins.length; i++){
            // 递归
            int res = search(coins, amount - coins[i]);
            // 确定最小值，注意区间[0, min)
            if(res >= 0 && res < min){
                // 加上这一次amount - coins[i]
                min = res + 1;
            }
        }
        // 更新数组的值
        memory[amount] = (min == amount + 1) ? -1 : min;
        return memory[amount];
    }
}
