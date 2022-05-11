/**
 * @author: Wxj
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>输入描述:
 * s = ")()())"
 * <p>输出描述:
 * 4
 */
package com.company.brush.dynamicprogramming;

// 方法一：动态规划 com/company/brush/dynamicprogramming/LongestValidParentheses.java

public class LongestValidParentheses {
    // 动态规划
    public int solution1(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return 0;
        // 表示以 i 为下标的字符作为结尾的子串满足连续有效括号的长度
        int[] dp = new int[n];
        // 初始条件
//        dp[0] = 0;
        // 最大值需要记录
        int max = 0;
        for (int i = 1; i < n; i++) {
            // 无需考虑以 左括号 结尾
            if (s.charAt(i) == ')') {
                // 情况：()
                if (s.charAt(i - 1) == '(') {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else { // s=() 的特殊情况，此时不存在dp[-1]
                        dp[i] = 2;
                    }
                } else if (s.charAt(i - 1) == ')') {
                    // 连续两个右括号有效的话，那么第一个右括号的前一位一定是左括号，一定有效
                    // 只需要检查有效子串的前一位 i - dp[i - 1] - 1
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                        } else { // s=(()) 的特殊情况，此时不存在dp[-1]
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
