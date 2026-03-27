package com.company.brush.doublePointer;

/**
 * @author: wangxinjian
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>输入描述:
 * [1,8,6,2,5,4,8,3,7]
 * <p>输出描述:
 * 49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class MaxArea {

    private static int maxArea(int[] height) {
        // 初始化最大面积为0
        int maxArea = 0;
        // 假设高一定,底边最长时,面积最长
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 计算当前位置最大面积
            int curArea = (right - left) * Math.min(height[left], height[right]);
            // 比较更新全局最大面积
            maxArea = Math.max(maxArea, curArea);
            // 根据木桶原理,短板一侧向中间移动
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
