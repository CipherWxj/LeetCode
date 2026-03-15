/**
 * @author: Wxj
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>输入描述:
 * [7,1,5,3,6,4]
 * <p>输出描述:
 * 5
 * 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class MaxProfit {
    public static int solution(int[] prices) {
        int maxProfit = 0; // 最大利润，初始化为0
        int minIndex = 0; // 最低价格的位置索引，初始假设第一天就是最低价格
        for (int i = 1; i < prices.length; i++) { // 从第二天开始遍历
            if (prices[i] > prices[minIndex]) { // 当天价格高于最低价格
                maxProfit = Math.max(prices[i] - prices[minIndex], maxProfit); // 计算最大的利润
            } else {
                // 当天价格低于或等于此前的最低价格，则将当天价格更新为最低价格
                minIndex = i;
            }
        }
        return maxProfit;
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
