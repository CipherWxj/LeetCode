/**
 * @author: Wxj
 * 209. 长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>输入描述:
 * target = 7, nums = [2,3,1,2,4,3]
 * <p>输出描述:
 * 2
 */
package com.company.brush.slidingwindow;

public class MinSubArrayLen {
    public int solution(int[] nums, int target) {
        int n = nums.length;
        // i：窗口右边界，j：窗口左边界
        int i = 0, j = 0;
        // 初始化最小长度为 n + 1，不可能的值（大）
        int minLen = n + 1;
        // 以右边界遍历
        for (; i < n; i++) {
            // 更新 target 值
            target -= nums[i];
            // target < 0，计算长度，更新
            // 左边界向右压缩，找最小
            while (j <= i && target <= 0) {
                minLen = Math.min(minLen, i - j + 1);
                // 压缩时要及时更新 target 值
                target += nums[j];
                j++;
            }
        }
        // 返回值要注意！！不存在返回 0
        return minLen == n + 1 ? 0 : minLen;
    }
}

