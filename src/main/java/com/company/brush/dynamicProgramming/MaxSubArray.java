package com.company.brush.dynamicProgramming;

/**
 * @author: wangxinjian
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>输入描述:
 * [-2,1,-3,4,-1,2,1,-5,4]
 * <p>输出描述:
 * 6
 */
public class MaxSubArray {
    private static int maxSubArray(int[] nums) {
        // 初始化动态规划数组，dp[i] 表示以i位置结尾的子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSubSum = dp[0];
        // 以第i个元素结尾的子数组的最大和，要么是第i个元素本身，要么是第i个元素加上第i-1个元素结尾的子数组的最大和
        // 状态转移方程：dp[i] = Math.max(nums[i], nums[i] + dp[i - 1])
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            maxSubSum = Math.max(maxSubSum, dp[i]);
        }
        return maxSubSum;
    }

    private static int maxSubArrayPlus(int[] nums) {
        // 初始化动态规划变量，dp 表示以i位置结尾的子数组的最大和
        int dp = nums[0];
        int maxSubSum = dp;
        // 以第i个元素结尾的子数组的最大和，要么是第i个元素本身，要么是第i个元素加上第i-1个元素结尾的子数组的最大和
        // 状态转移方程：dp[i] = Math.max(nums[i], nums[i] + dp[i - 1])
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(nums[i], nums[i] + dp);
            maxSubSum = Math.max(maxSubSum, dp);
        }
        return maxSubSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayPlus(nums));
    }
}
