/**
 * @author: Wxj
 * 1143. 最长公共子序列
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。
 * 如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>输入描述:
 * text1 = "abcde", text2 = "ace"
 * <p>输出描述:
 * 3
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class LongestCommonSubsequence {

    public static int solution(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0) return 0;
        // dp[i][j] 表示 text1[0,i] 和 text2[0,j] 的最长子串的长度
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        // 可以省略，Java 初始化int数组就全为 0
//        for (int i = 0; i < m + 1; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j < n + 1; j++) {
//            dp[0][j] = 0;
//        }
        // 递推
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 字符相等，dp[i][j] = dp[i - 1][j - 1] + 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 字符不等，dp[i][j] = dp[i - 1][j] 或 dp[i][j - 1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 打印输出
        int count = dp[m][n]; // 限制路径，如果不限制存在重复和干扰
        StringBuilder sub = new StringBuilder();
        // 逆序遍历
        for (int i = m; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                // 字符相等情况则添加
                // dp[i][j] == count 限制路径，严格递推
                if (dp[i][j] > dp[i-1][j] && dp[i][j] > dp[i][j-1] && dp[i][j] == count) {
                    sub.append(text1.charAt(i-1));
                    count--;
                }
            }
        }
        System.out.println(sub.reverse());

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("text1=");
        String text1 = sc.nextLine();
        System.out.print("text2=");
        String text2 = sc.nextLine();
        System.out.println(solution(text1, text2));
    }
}
