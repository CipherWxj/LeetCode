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

import java.util.Arrays;

public class SearchRange {
    public static int[] solution(int[] nums, int target){
        int leftIndex = binarySearchLeft(nums, target);
        int rightIndex = binarySearchRight(nums, target);
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }

    // 查找左边界
    public static int binarySearchLeft(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        // 左闭右开区间 [left, right） 上的二分查找
        // 最后跳出循环的条件是 left = right
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] >= target){
                right = mid; // （右开）
            }else {
                left = mid + 1; // （左闭）
            }
        }
        return left; // 不管怎么找，左边界一定不会越界，最大只可能到 left = right = nums.length - 1
    }

    // 找右边界
    public static int binarySearchRight(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        // 左闭右开区间 [left, right） 上的二分查找
        // 最后跳出循环的条件是 left = right
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] <= target){
                left = mid + 1; // 左闭
            }else {
                right = mid; // （右开）
            }
        }
        // 排除两种特殊情况：（1）最右侧元素为target；（2）单个元素的数组 left = 0（包含在第一种情况）
        if((left == nums.length - 1 && nums[left] == target) || left == 0) return left;
        // 因为是左闭右开区间，if(nums[mid] == target) left = mid + 1;
        // 此时 mid = left - 1,才是 target 的最右侧位置
        return left - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        System.out.println(Arrays.toString(solution(nums, 2)));
    }
}
