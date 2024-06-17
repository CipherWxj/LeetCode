/**
 * @author: Wxj
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>输入描述:
 * nums = [-1,0,3,5,9,12], target = 9
 * <p>输出描述:
 * 4
 */
package com.company.brush.search.binarysearch;

public class SearchTarget {
    public static int solution(int[] nums, int target) {

        // 闭区间 [left, right] 上的二分查找
        int left = 0, right = nums.length - 1;
        // 最后跳出循环的条件是 left=right+1  区间[right+1, right]
        while (left <= right) {
//            int mid = (left + right) >> 1; // 直接相加有int溢出风险
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1; // 闭区间
            } else if (target > nums[mid]) {
                left = mid + 1; // 闭区间
            }
        }
        return -1;

//        // 左闭右开区间 [left, right） 上的二分查找
//        int left = 0, right = nums.length;
//        // 最后跳出循环的条件是left=right  区间[left, right)
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (target < nums[mid]) {
//                right = mid; // 开区间
//            } else if (target > nums[mid]) {
//                left = mid + 1; // 闭区间
//            }
//        }
//        return -1;
    }
}
