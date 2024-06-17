/**
 * @author: Wxj
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
package com.company.brush.doublepointer;

public class MaxArea {

    public int solution(int[] height) {
        int max = 0, area = 0;
        // 左、右指针分别从两端遍历，相遇停止
        int l = 0, r = height.length - 1;
        while (l < r) {
            // ”短板效应“ 取高度小的计算面积
            if (height[l] > height[r]) {
                area = (r - l) * height[r];
                r--; // 右端高度小，左移
            } else {
                area = (r - l) * height[l];
                l++; // 左端高度小，右移
            }
            max = Math.max(max, area); // 更新最大面积
        }
        return max;
    }
}
