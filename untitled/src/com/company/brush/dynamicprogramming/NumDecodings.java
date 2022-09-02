/**
 * @author: Wxj
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>输入描述:
 * s = "226"
 * <p>输出描述:
 * 3
 */
package com.company.brush.dynamicprogramming;

import java.util.ArrayList;

public class NumDecodings {

    public static int solution(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        // 动态数组，dp[i]：表示到第 i 位的可能情况
        int[] f = new int[n + 1];
        // 初始值
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            // 一位数
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            // 两位数
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    // 回溯会超时
//    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//
//    public static int solution(String s) {
//        if (s.charAt(0) == '0') return 0;
//        dfs(s, 0, new ArrayList<Integer>());
//        return list.size();
//    }
//
//    public static void dfs(String s, int i, ArrayList<Integer> ans) {
//        if (i >= s.length()) {
//            list.add(new ArrayList<>(ans));
//            return;
//        }
//        if (s.charAt(i) == '0') return;
//        ans.add(s.charAt(i) - '0');
//        dfs(s, i + 1, ans);
//        ans.remove(ans.size() - 1);
//        if (i < s.length() - 1 && (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') < 27) {
//            ans.add((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0'));
//            dfs(s, i + 2, ans);
//            ans.remove(ans.size() - 1);
//        }
//    }
}
