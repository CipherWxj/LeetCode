package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: wangxinjian
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>输入描述:
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>输出描述:
 * 6
 */
public class WaterFlooding {

    public static int waterFlooding(int[] height) {
        int res = 0;
        // 初始化单调递减栈，栈里存数组位置索引，栈内元素对应的高度栈底到栈顶递减
        Deque<Integer> decStack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!decStack.isEmpty() && height[i] > height[decStack.peekFirst()]) {
                // 栈顶元素出栈，表示可接水位置
                int j = decStack.removeFirst();
                // 栈为空，表示左边没有比当前位置更高的位置，无法接水
                if (decStack.isEmpty()) break;
                // 左侧比位置j更高的位置decStack.peekFirst()，右侧比位置j更高的位置i
                int width = i - decStack.peekFirst() - 1;
                res += width * (Math.min(height[decStack.peekFirst()], height[i]) - height[j]);
            }
            decStack.addFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(waterFlooding(height));
    }
}
