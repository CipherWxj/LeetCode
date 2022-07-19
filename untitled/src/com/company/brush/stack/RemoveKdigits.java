/**
 * @author: Wxj
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，
 * 移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>输入描述:
 * num = "1432219", k = 3
 * <p>输出描述:
 * "1219"
 */
package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits {
    public static String solution(String num, int k) {
        int n = num.length();
        // 排除特殊情况
        if(n == k) return "0";
        // 维护一个单调栈，保证元素从下往上递增
        Deque<Character> stack = new LinkedList<>();
        int i = 0; // 遍历指针
        // 舍弃了 k 个 或 遍历完 终止
        while(k > 0 && i < n) {
            // 这里一定要用 while！！！保证递增
            while(k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.poll();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        // 遍历完还没删除 k 个，删除末尾的
        while(k > 0) {
            stack.poll();
            k--;
        }
        // 删除了 k 个还没遍历完，继续入栈
        while(i < n) {
            stack.push(num.charAt(i));
            i++;
        }
        // 栈里的元素依次出栈，顺序反了！！！
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.poll());
        }
        // 逆序
        String s = res.reverse().toString();
        // 排除前导 0！
        int j = 0;
        while(s.charAt(j) == '0' && j < s.length() - 1) j++; // 这里有坑……如果只剩一个 0，要保留！！！（j < s.length() - 1控制最后一个位置）
        return s.substring(j, s.length());
    }

    public static void main(String[] args) {
        System.out.println(solution("1432219", 3));
    }
}
