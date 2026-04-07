package com.company.brush.dynamicProgramming;

/**
 * @author: wangxinjian
 * 123. 买卖股票的最佳时机3
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>输入描述:
 * prices = [3,3,5,0,0,3,1,4]
 * <p>输出描述:
 * 6
 * 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 */
public class MaxProfit3 {
    // 动态规划
    public static int maxProfit3(int[] prices) {
        // 动态数组
        // dp[i][][]表示到第i天（包括第i天）获得的利润
        // dp[][0][]表示第i天结束手上没有股票获得的利润； dp[i][1][]表示第i天结束手上有股票获得的利润
        // dp[][][j]表示已经完成了第j次交易（买+卖）获得的利润
        int[][][] dp = new int[prices.length][2][3];

        // 初始状态
        // 第一天没有股票
        dp[0][0][0] = 0;
        // 第一天有股票，一定是买入
        dp[0][1][0] = -prices[0];
        // 不存在的情况，用最小值，java里整数类型的溢出 Integer.MIN_VALUE-1 是Integer.MAX_VALUE，避免出现该问题，故/2
        dp[0][0][1] = dp[0][1][1] = Integer.MIN_VALUE / 2;
        dp[0][0][2] = dp[0][1][2] = Integer.MIN_VALUE / 2;

        // 递推
        for (int i = 1; i < prices.length; i++) {
            // 第i天结束手上没有股票 且 没有进行过完整交易 获得的利润（啥都没干）
            dp[i][0][0] = dp[i - 1][0][0];
            // 第i天结束手上没有股票 且 进行过一次完整交易 获得的利润
            // 要么第i天啥也没干，所有操作在i-1天或之前完成；要么第i天卖出
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            // 第i天结束手上没有股票 且 进行过两次完整交易 获得的利润
            // 要么第i天啥也没干，所有操作在i-1天或之前完成；要么第i天卖出（第二次交易）；要么第i天卖出（第一次交易）
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
            // 第i天结束手上有股票 且 没有进行过完整交易 获得的利润
            // 要么第i天啥也没干，买入在i-1天或之前；要么第i天买入
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            // 第i天结束手上有股票 且 进行过一次完整交易 获得的利润
            // 要么第i天啥也没干，所有操作在i-1天或之前完成；要么第i天买入
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            // 第i天结束手上有股票 且 进行过两次完整交易 获得的利润（不存在的情况）
            dp[i][1][2] = Integer.MIN_VALUE / 2;
        }

        // 最后一定是手上没有股票利润更大: 0\1\2次交易
        return Math.max(dp[0][0][0], Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit3(prices));
    }
}
