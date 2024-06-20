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

import java.util.Arrays;
import java.util.Scanner;

public class MaxArea {

    public static int solution(int[] height) {
        int maxArea = 0;
        // 初始化双指针，left：左边垂线，right：右边垂线
        // 初始 left = 0，right = height.length - 1，不考虑高度，最宽面积最大
        int left = 0, right = height.length - 1;
        // 两侧向中间移动，相等时宽度为0，面积也为0
        while (left < right) {
            // 面积计算
            int heightNum = Math.min(height[left], height[right]);
            int widthNum = right - left;
            int area = widthNum * heightNum;
            maxArea = Math.max(maxArea, area);
            // 木桶原理：能装多少水取决于最短的木板
            // 左边垂线短，向右找高的；右边垂线短，向左找高的，另外一边不变
            // 如果左右两边垂线等高，移动任意一边都行，为什么呢？因为：
            // （1）假设等高的两条垂线h1、h2中间有一条更高的垂线h3，水桶高度还是取决于更短的h1或h2，向中间移动宽度减小，面积只可能更小
            // （2）假设等高的两条垂线h1、h2中间有两条更高的垂线h3，h4，迟早移动到h3，h4，最大面积只有可能是 h1和h2围成的区域 与 h3和h4围成的区域
            // （3）假设等高的两条垂线h1、h2中间有多条更高的垂线都可以转化成（1）和（2）来考虑
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数组：");
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] height = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            height[i] = Integer.parseInt(str[i]);
        }
        System.out.println(solution(height));
    }
}
