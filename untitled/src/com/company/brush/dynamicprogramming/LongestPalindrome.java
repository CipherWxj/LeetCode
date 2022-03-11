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

    //动态规划
    public static String solution2(String s) {
        int len = s.length(); // 字符串长度
        if (len < 2) return s; // 长度<2 的串一定是回文串

        // 二维动态数组，用于标记以 i位置 开头、j位置 结束的子串是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxL = 1, start = 0; // 最大长度、回文串开始位置

        // 以子串长度为变量遍历
        for (int L = 2; L <= len; L++) {
            // 起始位置遍历
            for (int i = 0; i < len; i++) {
                int j = i + L - 1; // 结束位置
                if (j >= len) break; // 右侧超出字符串范围，结束
                // 开头、末尾字符相同
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) { // 只含2、3个字符
                        dp[i][j] = true;
                    } else { // 字符数>3,中间向两侧递推
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                // 计算最大回文子串长度
                if (dp[i][j]) {
                    maxL = Math.max(j - i + 1, maxL);
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxL);
    }

    // 中心扩展法
    public static String solution3(String s) {
        int len = s.length(); // 字符串长度
        if (len < 2) return s; // 长度<2 的串一定是回文串
        int maxL = 0, start = 0; // 最大长度、回文串开始位置
        // 以索引为i的字符为中心向两侧扩展
        for (int i = 1; i < len; i++) {
            int l1 = expand(s, i, i); // 假设子串长度是奇数
            int l2 = expand(s, i - 1, i); // 假设子串长度是偶数
            int l = Math.max(l1, l2);
            if (l > maxL) {
                start = i - l / 2;
                maxL = l;
            }
        }
        return s.substring(start, start + maxL);
    }

    // 比较
    public static int expand(String s, int left, int right) {
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (--right) - (++left) + 1; // 这个返回值一定要注意！！！
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("s= ");
        String s = sc.nextLine();
        //System.out.println(solution1(s));
        System.out.println(solution2(s));
    }
}
