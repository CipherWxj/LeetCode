/**
 * @author: Wxj
 * 189. 轮转数组
 * 给给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>输入描述:
 * nums = [1,2,3,4,5,6,7], k = 3
 * <p>输出描述:
 * [5,6,7,1,2,3,4]
 */
package com.company.brush.array_string;

import java.util.Arrays;

public class RotateArray {
    public static void solution(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 循环时取余
            temp[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    // 数学方法
    public static void solution1(int[] nums, int k) {
        // 原始数组：[1,2,3,4,5,6,7]
        // 翻转所有元素：[7,6,5,4,3,2,1]
        reverse(nums, 0, nums.length - 1);
        // 翻转 [0,k % n − 1] 区间的元素：[5,6,7,4,3,2,1]
        reverse(nums, 0, k % nums.length - 1);
        // 翻转 [k % n,n − 1] 区间的元素：[5,6,7,1,2,3,4]
        reverse(nums, k % nums.length, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
