/**
 * @author: Wxj
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>输入描述:
 * s = "3+2*2"
 * <p>输出描述:
 * 7
 */
package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Calculate {
    public static int solution(String s) {
        Deque<Integer> numStack = new LinkedList<>(); // 数栈
        Deque<Character> symStack = new LinkedList<>(); // 符号栈
        int num = 0; // 多位数
        numStack.push(0); // 防止第一个字符是 - （负数）
        s = s + "@"; // 结束符

        for (int i = 0; i < s.length(); i++) {
            // 空格“ ”，跳过
            if (s.charAt(i) == ' ') continue;
            // 数字，暂存 num，判断是不是多位数
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
                continue;
            }
            // 遇到符号，说明数字更新完成，入栈
            numStack.push(num);
            // num置零！！！
            num = 0;
            // 遇到结束符，跳出
            if (s.charAt(i) == '@') break;
            // 优先级高的先计算 <
            // 同等优先级排在前面也要算 =
            // 并把结果入栈！！1
            while (!symStack.isEmpty() && level(s.charAt(i)) <= level(symStack.peek())) {
                numStack.push(cal(numStack.pop(), numStack.pop(), symStack.pop()));
            }
            // 运算符入栈
            symStack.push(s.charAt(i));
        }
        // 最后清空两个栈，得出结果
        while (!symStack.isEmpty()) {
            numStack.push(cal(numStack.pop(), numStack.pop(), symStack.pop()));
        }
        return numStack.pop();
    }

    // 计算
    public static int cal(int a, int b, char c) {
        switch (c) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                return b / a;
        }
        return 0;
    }

    // 判断优先级
    public static int level(char c) {
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(" 3/2 "));
    }
}
