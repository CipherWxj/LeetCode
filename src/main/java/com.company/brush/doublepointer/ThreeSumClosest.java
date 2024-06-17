/**
 * @author: Wxj
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * <p>输入描述:
 * nums = [-1,2,1,-4], target = 1
 * <p>输出描述:
 * 2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
package com.company.brush.doublepointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public int solution(int[] nums, int target) {
        // 数组排序
        Arrays.sort(nums);

        int n = nums.length;
        int best = Integer.MAX_VALUE; // 最优解，初始化为最大值
        // 确定 a
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i];
            // 维护双指针，更新 b 和 c
            int l = i + 1, r = n - 1;
            while (l < r) {
                int b = nums[l], c = nums[r];
                int sum = a + b + c;
                // 等于 target, 直接返回
                if (sum == target) return target;
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，左移 c 对应的指针
                    int rr = r - 1;
                    // 更新 r, 移动到下一个不相等的元素
                    while (l < rr && nums[rr] == c) {
                        --rr;
                    }
                    r = rr;
                } else {
                    // 如果和小于 target，右移 b 对应的指针
                    int ll = l + 1;
                    // 更新 l, 移动到下一个不相等的元素
                    while (ll < r && nums[ll] == b) {
                        ++ll;
                    }
                    l = ll;
                }
            }
        }
        return best;
    }
}
