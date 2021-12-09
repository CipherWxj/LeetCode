/**
 * @author: Wxj
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。
 * 当 needle 是空字符串时我们应当返回 0 。
 * <p>输入描述:
 * haystack = "hello"
 * needle = "ll"
 * <p>输出描述:
 * 2
 */
package com.company.brush;

import java.util.Scanner;

public class StrOfString {

    public static int solution(String haystack, String needle) {

        int i, j, cur; // 初始化遍历指针

        for (i = 0; i < haystack.length() - needle.length() + 1; i++) { // 末尾小于needle.length的位置无需遍历
            cur = i; // 当前比较的位置
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(cur) == needle.charAt(j)) {
                    cur++; // 字符相同，右移
                } else break;
            }
            if (j == needle.length()) {
                return i; // 遍历完返回开头位置索引
            }
        }
        return -1; // 不存在返回 -1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串 haystack=");
        String haystack = sc.nextLine();
        haystack = haystack.substring(1, haystack.length() - 1);
        System.out.print("请输入一个字符串 needle=");
        String needle = sc.nextLine();
        needle = needle.substring(1, needle.length() - 1);
        System.out.println(solution(haystack, needle));
    }
}
