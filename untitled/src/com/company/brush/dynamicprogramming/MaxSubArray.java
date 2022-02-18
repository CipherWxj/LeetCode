/**
 * @author: Wxj
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>输入描述:
 * [-2,1,-3,4,-1,2,1,-5,4]
 * <p>输出描述:
 * 6
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class MaxSubArray {

    // 动态规划
    public static int solution(int[] nums) {
        int[] dp = new int[nums.length]; // dp[] 记录以i为结尾的子数组的和
        int max = nums[0]; // 最大值存储
        dp[0] = nums[0]; // 初始状态
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]); // 只需要比较 前面子串与该位置的和 与 该位置的值 的大小
            max = Math.max(max, dp[i]); // 与存储的最大值进行比较
        }
        return max;
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
