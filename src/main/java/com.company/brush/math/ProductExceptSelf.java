/**
 * @author: Wxj
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>输入描述:
 * nums = [-1,1,0,-3,3]
 * <p>输出描述:
 * [0,0,9,0,0]
 */
package com.company.brush.math;

import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] solution(int[] nums) {
        // 初始化左乘积数组
        // leftProduct[i]表示位置i左侧所有数字的乘积，即数组nums中[0,i)的乘积
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
        }
        // 初始化右乘积数组
        // leftProduct[i]表示位置i右侧所有数字的乘积，即数组nums中(i,n-1]的乘积
        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            rightProduct[j] = nums[j + 1] * rightProduct[j + 1];
        }
        // 左侧乘积*右侧乘积
        int[] answers = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            answers[k] = leftProduct[k] * rightProduct[k];
        }
        return answers;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4})));
    }
}
