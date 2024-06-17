/**
 * @author: Wxj
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>输入描述:
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <p>输出描述:
 * 6
 */
package com.company.brush.stack;

import java.util.Stack;

/*
 * 方法1：动态规划 com/company/brush/dynamicprogramming/WaterFlooding.java
 * 方法2：单调栈 com/company/brush/stack/WaterFlooding.java
 * 方法3：双指针 com/company/brush/doublepointer/WaterFlooding.java
 */
public class WaterFlooding {

    // 单调栈
    public static int solution2(int[] height) {
        int len = height.length;
        // 维护一个单调栈，里面存储的元素是 height 的元素索引
        // 只要height里的元素 递减，就把该元素位置添加进栈
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < len; i++) {
            // 栈不为空，判断是继续添加元素还是计算储水量
            // 当前位置比前一位置高，计算
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 取出当前位置
                int cur = stack.pop();
                // 取出位置后栈为空，说明两个位置挨着，不用计算了
                if (stack.isEmpty()) break;
                // 可储水区域的左侧边界
                int left = stack.peek();
                // 储水区域的宽度
                // 这里不是1，因为栈是递减的，相等的位置也没进栈，存在连续可储水位置
                int width = i - left - 1;
                // 储水区域的高度
                int high = Math.min(height[left], height[i]) - height[cur];
                res += width * high;
            }
            // 当前位置比前一位置低，进栈
            stack.push(i);
        }
        return res;
    }
}
