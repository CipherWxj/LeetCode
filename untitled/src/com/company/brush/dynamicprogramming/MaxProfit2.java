/**
 * @author: Wxj
 * 122. 买卖股票的最佳时机2
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * <p>输入描述:
 * [7,1,5,3,6,4]
 * <p>输出描述:
 * 7
 * 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class MaxProfit2 {
    // 动态规划
    public static int solution(int[] prices) {
        // 动态数组
        // dp[i][]表示到第i天（包括第i天）获得的利润
        // dp[i][0]表示第i天结束手上没有股票； dp[i][0]表示第i天结束手上有股票
        int[][] dp = new int[prices.length][2];

        // 初始状态
        dp[0][0] = 0; // 第一天没有股票
        dp[0][1] = -prices[0]; // 第一天有股票，一定是买入

        // 递推
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 最后一定是手上没有股票利润更大
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println("请输入股价数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solution(arr));
    }
}
