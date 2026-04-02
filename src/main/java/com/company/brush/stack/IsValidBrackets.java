package com.company.brush.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: wangxinjian
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
public class IsValidBrackets {
    public static boolean isValidBrackets(String s) {
        // 初始化哈希表，key：左括号，value：对应的右括号
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是左括号，入栈
            if (map.containsKey(c)) {
                stack.push(c);
            } else { // 如果是右括号，去匹配栈顶的左括号
                // 没匹配上，返回false
                if (stack.isEmpty() || c != map.get(stack.peek())) return false;
                // 匹配上，栈顶的左括号出栈
                stack.pop();
            }
        }
        // 如果全部匹配，最后栈为空
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()[]{}";
        System.out.println(isValidBrackets(s));
    }
}
