/**
 * @author: Wxj
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>输入描述:
 * nums = [10,9,2,5,3,7,101,18]
 * <p>输出描述:
 * 4
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class lengthOfLIS {
    // 动态规划
    public static int solution(int[] nums) {
        int len = nums.length;
        // 表示以 i 位置结尾的最长递增子串的长度
        int[] dp = new int[len];
        // 初始状态
        dp[0] = 1;
        // 最长的长度
        int max = 1;
        for (int i = 1; i < len; i++) {
            // 每一个单个数都是一个子串
            dp[i] = 1;
            // 递推，在 i 位置以前所有位置搜索
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

//        // 记录路径，只能记录一条
//        int[] trace = new int[max];
//        for (int i = 0; i < len; i++) {
//            trace[dp[i] - 1] = nums[i];
//        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nums=");
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solution(nums));
    }
}
