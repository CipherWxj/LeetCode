/**
 * @author: Wxj
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>输入描述:
 * nums = [1,2,1,3,5,6,4]
 * <p>输出描述:
 * 1 或 5
 */
package com.company.brush.search.binarysearch;

public class FindPeakElement {
    //在题目描述中出现了 nums[-1] = nums[n] = -∞，
    // 这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
    // (可以反推)

    // 根据左右指针计算中间位置 mid，并比较 mid 与 mid+1 的值，
    // 如果 mid 较大，则左侧存在峰值，right = mid，
    // 如果 mid+1 较大，则右侧存在峰值，left = mid+1
    public int solution(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
