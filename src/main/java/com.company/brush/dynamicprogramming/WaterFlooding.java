/**
 * @author: Wxj
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>输入描述:
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>输出描述:
 * 6
 */
package com.company.brush.dynamicprogramming;

/*
 * 方法1：动态规划 com/company/brush/dynamicprogramming/WaterFlooding.java
 * 方法2：单调栈 com/company/brush/stack/WaterFlooding.java
 * 方法3：双指针 com/company/brush/doublepointer/WaterFlooding.java
 */
public class WaterFlooding {
    // 动态规划
    public static int solution1(int[] height) {
        int len = height.length;

        // 两个数组分别表示每个位置上左右两侧（包括该位置）的最大高度
        int[] left = new int[len];
        int[] right = new int[len];

        // 初始化
        left[0] = height[0];
        right[len - 1] = height[len - 1];

        // 计算左侧最大高度
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        // 计算右侧最大高度
        for (int i = len - 2; i > -1; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        // 结果取最小的高度 - 柱子的高度
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += (Math.min(left[i], right[i]) - height[i]);
        }
        return res;
    }
}
