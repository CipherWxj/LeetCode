/**
 * @author: Wxj
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>输入描述:
 * nums = [1,2,3,1]
 * <p>输出描述:
 * 4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 */
package com.company.brush.dynamicprogramming;

public class Rob2 {

    public int solution(int[] nums) {
        int n = nums.length;
        // 只有一间房屋，唯一选择
        if (n == 1) return nums[0];
        // 两间房屋，二者选其一
        if (n == 2) return Math.max(nums[0], nums[1]);
        // 三间及以上，因为头和尾只能选一个，分两种情况讨论，选最大的那个
        return Math.max(get(nums, 0, n - 2), get(nums, 1, n - 1));
    }

    public int get(int[] nums, int l, int r) {
        int n = r - l + 1;
        // dp[i]表示到达[l, r]区间子数组中第 i 间房屋时能获得的最大金额
        int[] dp = new int[n];
        // 初始值
        dp[0] = nums[l];
        dp[1] = Math.max(nums[l], nums[l + 1]);
        // 递推，到达第 i 间房屋时，可选偷 或 不偷
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + l], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
