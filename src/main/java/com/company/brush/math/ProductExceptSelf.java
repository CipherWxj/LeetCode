package com.company.brush.math;

import java.util.Arrays;

/**
 * @author: wangxinjian
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>输入描述:
 * nums = [-1,1,0,-3,3]
 * <p>输出描述:
 * [0,0,9,0,0]
 */
public class ProductExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // productLeft[i]表示第i位左侧所有数的乘积
        int[] productLeft = new int[len];
        productLeft[0] = 1;
        for (int l = 1; l < len; l++) {
            productLeft[l] = nums[l - 1] * productLeft[l - 1];
        }
        // productRight[i]表示第i位右侧所有数的乘积
        int[] productRight = new int[len];
        productRight[len - 1] = 1;
        for (int r = len - 2; r > -1; r--) {
            productRight[r] = nums[r + 1] * productRight[r + 1];
        }
        // answer[i]等于第i位左侧所有数的乘积乘以第i位右侧所有数的乘积
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = productLeft[i] * productRight[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
