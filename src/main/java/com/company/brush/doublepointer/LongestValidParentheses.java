/**
 * @author: Wxj
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>输入描述:
 * s = ")()())"
 * <p>输出描述:
 * 4
 */
package com.company.brush.doublepointer;

/*
 * 方法1：动态规划 com/company/brush/dynamicprogramming/LongestValidParentheses.java
 * 方法2：栈 com/company/brush/stack/LongestValidParentheses.java
 * 方法3：双指针遍历（贪心算法）com/company/brush/doublepointer/LongestValidParentheses.java
 */

public class LongestValidParentheses {
    // 贪心算法
    public int solution1(String s) {
        int left = 0, right = 0, maxlength = 0;
        // 从左向右遍历
        for (int i = 0; i < s.length(); i++) {
            // 左括号计数
            if (s.charAt(i) == '(') {
                left++;
            } else { // 右括号计数
                right++;
            }
            // 左括号数等于右括号数计算有效括号数
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) { // 右括号数大于左括号数舍弃前面的子串
                left = right = 0;
            }
        }
        left = right = 0;
        // 为了避免左括号数一直大于右括号数，反向遍历一次
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
