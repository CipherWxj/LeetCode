/**
 * @author: Wxj
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>输入描述:
 * nums = [2,3,1,1,4]
 * <p>输出描述:
 * 2
 */
package com.company.brush.dynamicprogramming;

import java.util.Arrays;

public class Jump {
    // 动态规划
    public int solution(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n) {
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                }
            }
        }
        return dp[n - 1];
    }

    // 贪心算法
    public int solution2(int[] nums) {
        int n = nums.length;
        int step = 0; // 步数
        int maxPos = 0; // 下一步能跳到的最远位置
        int end = 0; // 当前所能到达的最远位置
        for (int i = 0; i < n; i++) {
            maxPos = Math.max(maxPos, i + nums[i]); // 更新
            // 到达当前阶段能到的最远位置
            if (i == end) {
                end = maxPos; // 更新下一阶段能到的最远位置
                step++; // 跳跃次数+1
            }
        }
        return step;
    }
}
