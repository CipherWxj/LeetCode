/**
 * @author: Wxj
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 回文串：字符串无论从左读还是从右读,所读的顺序是一样的;简而言之,回文串是 左右对称 的.
 * <p>输入描述:
 * s = babad
 * <p>输出描述:
 * bab or aba
 */
package com.company.brush.dynamicprogramming;

import java.util.Scanner;

public class LongestPalindrome {

    //暴力求解，（会报错，超出时间限制！！）
    public static String solution1(String s) {
        String res = String.valueOf(s.charAt(0)); //假设所有字符均不相同，不妨返回第一个元素

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) { //遍历
                if (s.charAt(i) == s.charAt(j)) { //找到首尾相同字符
                    String temp = s.substring(i, j + 1); //截取首尾字符相同的字符串
                    if (findPalindrome(temp) && temp.length() > res.length()) { //是回文串，且最长
                        res = temp;
                    }
                }
            }
        }
        return res;
    }

    //判断是否是回文串，左右对称
    public static boolean findPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) { //对称位置字符比较
                return false;
            }
        }
        return true;
    }

    //官方解法，动态规划
    public static String solution2(String s) {
        int len = s.length();

        //长度小于2的字符串返回其本身
        if (len < 2) {
            return s;
        }

        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        // 递推开始

        int maxLen = 1;
        int begin = 0;
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L
                int j = i + L - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false; //左边界和右边界不相等，返回false
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true; //L=2且相等，返回true
                    } else {
                        dp[i][j] = dp[i + 1][j - 1]; //L>2且左右边界相等，左边界右移，右边界左移
                    }
                }

                // 只要 dp[i][i+L-1] == true 成立，就表示子串 s[i..i+L-1] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("s= ");
        String s = sc.nextLine();
        //System.out.println(solution1(s));
        System.out.println(solution2(s));
    }
}
