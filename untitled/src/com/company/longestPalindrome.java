/**
 * @author: Wxj
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 回文串:字符串无论从左读还是从右读,所读的顺序是一样的;简而言之,回文串是 左右对称 的.
 * <p>输入描述:
 * s = babad
 * <p>输出描述:
 * bab or aba
 */
package com.company;

import java.util.Scanner;

public class longestPalindrome {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("s= ");
        String s = sc.nextLine();
        System.out.println(solution1(s));
    }
}
