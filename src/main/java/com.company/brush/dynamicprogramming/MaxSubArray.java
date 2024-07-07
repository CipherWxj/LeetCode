/**
 * @author: Wxj
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>输入描述:
 * [-2,1,-3,4,-1,2,1,-5,4]
 * <p>输出描述:
 * 6
 * 注：下面代码稍微复杂，为了找出符合条件的一个子数组。
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class MaxSubArray {
    // 动态规划
    public static int solution(int[] nums) {
        // 动态数组，dp[i]：以i位置结尾的子数组的最大和
        int[] dp = new int[nums.length];

        int maxSubSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // 某一位结尾的字数组的和最大值要么是它本身nums[i]，要么是前一位结尾的子数组的最大和+它本身nums[i] + dp[i - 1]
            // 兼容第一位，第一位结尾的子数组只有它本身
            if (i > 0 && nums[i] + dp[i - 1] > nums[i]) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            // 更新结果
            maxSubSum = Math.max(maxSubSum, dp[i]);
        }
        return maxSubSum;
    }

    public static int solution1(int[] nums) {
        // 初始化dp
        int dp = nums[0];

        int maxSubSum = dp;

        for (int i = 1; i < nums.length; i++) {
            // 某一位结尾的字数组的和最大值要么是它本身nums[i]，要么是前一位结尾的子数组的最大和+它本身nums[i] + dp
            // 兼容第一位，第一位结尾的子数组只有它本身
            dp = Math.max(nums[i] + dp, nums[i]);
            // 更新结果
            maxSubSum = Math.max(maxSubSum, dp);
        }
        return maxSubSum;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个整数数组：");
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
