/**
 * @author: Wxj
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * <p>输入描述:
 * nums = [5,7,7,8,8,10], target = 8
 * <p>输出描述:
 * [3,4]
 */
package com.company.brush.search.binarysearch;

public class SearchRange {
    public int[] search(int[] nums, int target) {
        int r = helperR(nums, target);
        int l = helperL(nums, target);
        if (l <= r && r < nums.length && nums[l] == target && nums[r] == target) {
            return new int[]{l, r};
        }
        return new int[]{-1, -1};
    }

    // 二分法查找 target 的右边界
    public int helperR(int[] nums, int tar) {
        int left = 0, right = nums.length - 1;
        // 闭区间[left,right]上的二分
        while (left <= right) {
            int m = (left + right) / 2;
            if (nums[m] == tar) { // 相等，左边界继续右移，因为是找右边界
                left = m + 1;
            } else if (nums[m] < tar) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        // 最后 left 停在 最后一个tar 的下一位
        return left - 1;
    }

    // 二分法查找 target 的左边界
    public int helperL(int[] nums, int tar) {
        int left = 0, right = nums.length - 1;
        // 闭区间[left,right]上的二分
        while (left <= right) {
            int m = (left + right) / 2;
            if (nums[m] == tar) { // 相等，右边界继续左移，因为是找左边界
                right = m - 1;
            } else if (nums[m] < tar) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        // 最后 right 停在 第一个tar 的前一位
        return right + 1;
    }
}
