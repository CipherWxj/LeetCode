package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author: wangxinjian
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 * <p>输入描述:
 * s = "3[a]2[bc]"
 * <p>输出描述:
 * aaabcbc
 */
public class DecodeString {
    public static String decodeString(String s) {
        // 一个栈保存数字，一个栈保存字符串
        Deque<String> strStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        // 保存遍历的字符串结果
        StringBuilder res = new StringBuilder();
        // 记录当前字符串需要循环的次数
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符是数字，暂时保存，直到遇到下一个左括号，才是左括号里的字符需要循环的次数
            if ('0' <= c && c <= '9') {
                num = num * 10 + c - '0';
            } else if ('a' <= c && c <= 'z') { // 如果当前字符是字母，暂时保存在结果里，直到遇到下一个左括号，才入栈暂存
                res.append(c);
            } else if (c == '[') { // 遇到左括号，将当前数字入栈，并重置数字，将当前字符串入栈，并重置字符串
                numStack.push(num);
                num = 0;
                strStack.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') { // 遇到右括号，将当前字符串循环k次，与栈顶字符串连接，入栈
                int k = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    temp.append(res);
                }
                res = new StringBuilder(strStack.pop() + temp);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("30[a]2[bc]"));
    }
}
