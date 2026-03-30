package com.company.brush.arrayOrString;

import java.util.Arrays;

/**
 * @author: wangxinjian
 * 189. 轮转数组
 * 给给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>输入描述:
 * nums = [1,2,3,4,5,6,7], k = 3
 * <p>输出描述:
 * [5,6,7,1,2,3,4]
 */
public class RotateArray {
    private static void rotateArray(int[] nums, int k) {
        // k 有可能大于数组长度，需要取余
        k = k % nums.length;
        // 先反转前 n-k 个元素
        rotateWithIndex(nums, 0, nums.length - k - 1);
        // 再反转后 k 个元素
        rotateWithIndex(nums, nums.length - k, nums.length - 1);
        // 最后反转整个数组
        rotateWithIndex(nums, 0, nums.length - 1);
    }

    private static void rotateWithIndex(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArray(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
