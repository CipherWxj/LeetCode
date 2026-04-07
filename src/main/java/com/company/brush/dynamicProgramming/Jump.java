package com.company.brush.dynamicProgramming;

import java.util.Arrays;

/**
 * @author: wangxinjian
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
public class Jump {

    public static int jump(int[] nums) {
        // 初始化动态数组，dp[i]表示到达第i位需要跳跃的最小次数
        int[] dp = new int[nums.length];
        // 初始化数组中存储可能的最大值
        Arrays.fill(dp, nums.length - 1);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            // 以i为跳板，计算下一步能到达的位置时的最小跳跃次数，即i+1到i+nums[i]位置
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j > nums.length - 1) break;
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
