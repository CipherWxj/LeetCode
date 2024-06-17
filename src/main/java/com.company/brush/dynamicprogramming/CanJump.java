/**
 * @author: Wxj
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
package com.company.brush.dynamicprogramming;

public class CanJump {
    public static boolean solution1(int[] nums) {
        int n = nums.length;
        // 能到达的位置为 true
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue; // 不能到达，跳过
            // 依次将能到达的位置置为ture
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n - 1) {
                    dp[i + j] = true;
                } else {
                    return true; // 超过了终点直接返回 true
                }
            }
        }
        return dp[n - 1];
    }

    // 贪心算法
    public boolean solution2(int[] nums) {
        int n = nums.length;
        int rightmost = 0; // 能到达的最右侧位置
        for (int i = 0; i < n; ++i) {
            // 在能到达的范围里的位置
            if (i <= rightmost) {
                // 更新能到达的最右侧位置
                rightmost = Math.max(rightmost, i + nums[i]);
                // 超过最右侧，返回 true
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution1(new int[]{3, 2, 1, 0, 4}));
    }
}
