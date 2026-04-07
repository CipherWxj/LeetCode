package com.company.brush.dynamicProgramming;

/**
 * @author: wangxinjian
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>输入描述:
 * nums = [2,3,1,1,4]
 * <p>输出描述:
 * true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        // 初始化动态数组，dp[i]表示第i位是否能到达，true：能
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            // 如果第i位能到达，判断下一步能到达的位置，即i+1到i+nums[i]位置
            if (dp[i]) {
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    // 防止越界
                    if (j > nums.length - 1) break;
                    dp[j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}