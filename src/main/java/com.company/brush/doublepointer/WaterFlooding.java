/**
 * @author: Wxj
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>输入描述:
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>输出描述:
 * 6
 */
package com.company.brush.doublepointer;

import java.util.Scanner;

/*
 * 方法1：动态规划 com/company/brush/dynamicprogramming/WaterFlooding.java
 * 方法2：单调栈 com/company/brush/stack/WaterFlooding.java
 * 方法3：双指针 com/company/brush/doublepointer/WaterFlooding.java
 */
public class WaterFlooding {

    // 双指针解法
    // 某根柱子i能存多少水由它左右两侧最高的柱子和它本身决定，存水高度：h = Math.min(leftMaxH, rightMaxH) - height[i]
    // 不管距离多远，只要左右两侧有比它高的柱子，那么该柱子上面一定可以存水
    public static int solution3(int[] height) {
        int res = 0;
        // 初始化双指针，left：从左往右遍历，right：从右往左遍历
        int left = 0, right = height.length - 1;
        // 初始化两个变量，leftMaxH记录left左侧柱子的最大高度，rightMaxH记录right右侧侧柱子的最大高度
        // 初始值都为0
        int leftMaxH = 0, rightMaxH = 0;
        while (left < right) {
            // 左侧移动，更新左侧最大高度
            leftMaxH = Math.max(leftMaxH, height[left]);
            // 右侧移动，更新右侧最大高度
            rightMaxH = Math.max(rightMaxH, height[right]);
            // 水桶原理，高度更低的先移动
            if (height[left] < height[right]) { // 左侧低于右侧，左指针右移
                res += leftMaxH - height[left];
                left++;
            } else { // 右侧低于等于左侧，右指针左移
                res += rightMaxH - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("请输入整数数组：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] height = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            height[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solution3(height));
    }
}
