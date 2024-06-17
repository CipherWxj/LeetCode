/**
 * @author: Wxj
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * 测试用例的答案是一个m32-位 整数。
 * 子数组 是数组的连续子序列。
 * <p>输入描述:
 * [2,3,-2,4]
 * <p>输出描述:
 * 6
 */
package com.company.brush.dynamicprogramming;

public class MaxSubArrayProduct {
    // 类比 最大子数组的和（leetcode 53）
    // 乘法需要考虑正负！！！最小值为负*负数=最大值
    public int solution(int[] nums) {
        int n = nums.length;
        int max = 0;
        // 动态数组
        // dpMin[i]：以 i 位置结尾的子数组的最小乘积
        // dpMax[i]：以 i 位置结尾的子数组的最大乘积
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];

        // 初始值
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // 三个值比较！！！
            // 本身、最大值为正*正数、最小值为负*负数
            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]));
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
