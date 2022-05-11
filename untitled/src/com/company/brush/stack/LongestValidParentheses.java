/**
 * @author: Wxj
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>输入描述:
 * s = ")()())"
 * <p>输出描述:
 * 4
 */
package com.company.brush.stack;

/*
 * 方法1：动态规划 com/company/brush/dynamicprogramming/LongestValidParentheses.java
 * 方法2：栈 com/company/brush/stack/LongestValidParentheses.java
 * 方法3：双指针遍历（贪心算法）com/company/brush/doublepointer/LongestValidParentheses.java
 */

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
    // 栈
    public int solution2(String s) {
        Deque<Integer> stack = new LinkedList<>();
        // 初始化压入 -1 方便计算，保证栈底不为空
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                // 将匹配的左括号从栈顶弹出
                stack.pop();
                // 保证栈底不为空
                if (stack.isEmpty()) {
                    stack.push(i);
                } else { // 计算
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
