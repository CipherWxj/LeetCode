/**
 * @author: Wxj
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>输入描述:
 * n = 3
 * <p>输出描述:
 * ["((()))","(()())","(())()","()(())","()()()"]
 */
package com.company.brush.backtracking;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParenthesis {
    public static List<String> solution(int n) {
        List<String> res = new ArrayList<>();
        backtrak(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    // 回溯
    public static void backtrak(int n, int left, int right, StringBuilder s, List<String> res) {
        // 终止条件：左、右括号都有 n 个
        if (left == n && right == n) {
            res.add(s.toString());
            return;
        }

        // 左括号的个数 小于 n
        // 继续添加左括号
        if (left < n) {
            s.append('(');
            backtrak(n, left + 1, right, s, res);
            // 每次移除最后一个元素 回溯
            s.deleteCharAt(s.length() - 1);
        }
        // 右括号一定需要对应的左括号去匹配
        // 右括号的个数 小于 左括号 继续添加右括号
        if (right < left) {
            s.append(')');
            backtrak(n, left, right + 1, s, res);
            // 回溯
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt()));
    }
}
