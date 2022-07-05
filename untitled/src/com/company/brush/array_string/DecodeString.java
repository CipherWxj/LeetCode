/**
 * @author: Wxj
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
package com.company.brush.array_string;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public static String solution(String s){
        // 维护两个栈，一个存字符，一个存数字
        Deque<String> strStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();

        int count = 0; // 初始化计数器
        StringBuilder res = new StringBuilder(); // 初始化结果字符串

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 数字，下一位还是数字的话就有多位数，计算
            if(c>='0' && c<='9'){
                count = count * 10 + c - '0';
            }else if(c == '['){ // 左括号
                // 将数字入栈，并将计数器置 0
                numStack.push(count);
                count = 0;
                // 将已经确定的结果字符入栈，将结果串置为 “”
                strStack.push(res.toString());
                res = new StringBuilder();
            }
            else if(c==']') { // 右括号
                // 将暂存的 结果串 循环解码
                StringBuilder temp = new StringBuilder();
                int n = numStack.removeLast();
                for (int j = 0; j < n; j++) {
                    temp.append(res);
                }
                // 与 前面已经确定的串 连接
                res = new StringBuilder(strStack.removeLast() + temp);
            }else { // 是字符（两个中括号之间的）放入结果串 暂存
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("3[a]2[bc]"));
    }
}
