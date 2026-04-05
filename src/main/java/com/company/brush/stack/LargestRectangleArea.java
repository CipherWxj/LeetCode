package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangxinjian
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>输入描述:
 * height = [2,1,5,6,2,3]
 * <p>输出描述:
 * 10
 */
public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        // 初始化单调递增栈，栈里存数组位置索引，栈内元素对应的高度栈底到栈顶递增
        Deque<Integer> incStack = new LinkedList<>();
        // leftMin[i] 表示位置 i 左边第一个比 heights[i] 小的位置索引，如果不存在则为 -1
        int[] leftMin = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            // 如果栈不为空且当前高度小于等于栈顶高度，则弹出栈顶
            while (!incStack.isEmpty() && heights[i] <= heights[incStack.peekFirst()]) {
                incStack.removeFirst();
            }
            // 栈为空则表示位置 i 左边没有比 heights[i] 小的位置，否则栈顶即为所求位置
            leftMin[i] = incStack.isEmpty() ? -1 : incStack.peekFirst();
            // 将当前位置索引压入栈
            incStack.addFirst(i);
        }
        incStack.clear();
        // rightMin[i] 表示位置 i 右边第一个比 heights[i] 小的位置索引，如果不存在则为 heights.length
        int[] rightMin = new int[heights.length];
        for (int i = heights.length - 1; i > -1; i--) {
            // 如果栈不为空且当前高度小于等于栈顶高度，则弹出栈顶
            while (!incStack.isEmpty() && heights[i] <= heights[incStack.peekFirst()]) {
                incStack.removeFirst();
            }
            // 栈为空则表示位置 i 右边没有比 heights[i] 小的位置，否则栈顶即为所求位置
            rightMin[i] = incStack.isEmpty() ? heights.length : incStack.peekFirst();
            incStack.addFirst(i);
        }
        int res = 0;
        // 以 height[i] 为高度的最大矩形面积，由位置 i 的左右两边第一个比 heights[i] 小的位置决定
        for (int i = 0; i < heights.length; i++) {
            // 获取位置 i 的高度
            int height = heights[i];
            // 获取位置 i 的左边第一个比 heights[i] 小的位置索引
            int left = leftMin[i];
            // 获取位置 i 的右边第一个比 heights[i] 小的位置索引
            int right = rightMin[i];
            res = Math.max(res, height * (right - left - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
