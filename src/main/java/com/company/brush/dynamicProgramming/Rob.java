package com.company.brush.dynamicProgramming;

/**
 * @author: wangxinjian
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
public class Rob {
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 初始化动态变量，lastTwo表示偷窃到上上间房屋的最大金额，lastOne表示偷窃到上间房屋的最大金额
        // 到第i间房屋时，小偷只有两种选择，要么偷窃：上上间房屋的最大金额 + 当前房屋金额，要么不偷窃：上间房屋的最大金额
        int lastTwo = nums[0];
        int lastOne = Math.max(lastTwo, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(lastTwo + nums[i], lastOne);
            lastTwo = lastOne;
            lastOne = cur;
        }
        return lastOne;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
