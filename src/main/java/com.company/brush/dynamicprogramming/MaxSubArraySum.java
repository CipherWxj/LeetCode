/**
 * @author: Wxj
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>输入描述:
 * [-2,1,-3,4,-1,2,1,-5,4]
 * <p>输出描述:
 * 6
 * 注：下面代码稍微复杂，为了找出符合条件的一个子数组。
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class MaxSubArraySum {

    // 动态规划
    public static int solution(int[] nums) {
        int pre = nums[0]; // 记录以 i位置 为结尾的子数组的最大和
        int max = nums[0]; // 最大值
        int l = 0, r = 0; // 每一位 子数组的左右位置
        int ml = 0, mr = 0; // 保存最大和子数组的左右位置
        for (int i = 1; i < nums.length; i++) {
            // 前面最大和子数组 + 该位置 > 该位置
            // 子数组起始位置不变
            if (pre + nums[i] > nums[i]) {
                pre += nums[i];
            } else {
                // 前面最大和子数组 + 该位置 <= 该位置
                // 子数组起始位置变为当前位置
                pre = nums[i];
                l = i;
            }
            // 子数组终止位置变为当前位置
            r = i;

            // 更新最大值
            if(max < pre) {
                max = pre;
                ml = l;
                mr = r;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个整数数组：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solution(arr));
    }
}
