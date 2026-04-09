package com.company.brush.binarySearch;

import java.util.Arrays;

/**
 * @author: wangxinjian
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
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int lowRange = searchLowRange(nums, target);
        int highRange = searchHighRange(nums, target);
        // 判断下标是否越界，以及下标位置的值是否等于target
        if (lowRange <= highRange && highRange < nums.length && nums[lowRange] == target && nums[highRange] == target)
            return new int[]{lowRange, highRange};
        return new int[]{-1, -1};
    }

    // 查找下限
    public static int searchLowRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // 相等继续向左寻找
                right = mid - 1;
            }
        }
        // 最后一次比较 mid = left = right，
        // 如果 nums[mid] == target，right = mid - 1，所以返回right + 1
        return right + 1;
    }

    // 查找上限
    public static int searchHighRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // 相等继续向右寻找
                left = mid + 1;
            }
        }
        // 最后一次比较 mid = left = right，
        // 如果 nums[mid] == target，left = mid + 1，所以返回left - 1
        return left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
