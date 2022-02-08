/**
 * @author: Wxj
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合；
 * 左括号必须以正确的顺序闭合。
 * <p>输入描述:
 * ()[]{}
 * <p>输出描述:
 * true
 */
package com.company.brush.Stack;

import java.util.Scanner;
import java.util.Stack;

public class BracketsValid {

    public static boolean solution(String s) {

        char temp; // 字符存储变量
        Stack<Character> bracketsStack = new Stack<>(); // 符号暂存栈

        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{') { // 左括号直接入栈
                bracketsStack.push(temp);
            }
            // 右括号分别判断栈是否为空、括号顺序是否正确
            // 正确的话顶部左括号出栈
            else if (temp == ')') {
                if (!bracketsStack.isEmpty() && bracketsStack.peek() == '(') {
                    bracketsStack.pop();
                } else
                    return false;
            } else if (temp == ']') {
                if (!bracketsStack.isEmpty() && bracketsStack.peek() == '[') {
                    bracketsStack.pop();
                } else
                    return false;
            } else if (temp == '}') {
                if (!bracketsStack.isEmpty() && bracketsStack.peek() == '{') {
                    bracketsStack.pop();
                } else
                    return false;
            }
        }
        return bracketsStack.isEmpty(); // 如果最后所有符号完成出入栈操作，栈为空，则返回true
    }

    public static void main(String[] args) {

        System.out.print("请输入一个只包含括号字符的字符串：");

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solution(s));
    }
}
