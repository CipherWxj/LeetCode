/**
 * @author: Wxj
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>输入描述:
 * [2,7,9,3,1]
 * <p>输出描述:
 * 12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
package com.company.brush.dynamicprogramming;

public class Rob {
    public int solution(int[] nums) {
        int n = nums.length;
        // 动态数组
        // dp[i + 1]表示到达第 i 间房子时的最大金额
        // 前两位dp[0]、dp[1]为了递推赋初值0
        int[] dp = new int[n + 2];
//       // 初始值
//        dp[0] = 0;
//        dp[1] = 0;
        dp[2] = nums[0];
        // 递推
        for (int i = 3; i < n + 2; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        return dp[n + 1];
    }
}
