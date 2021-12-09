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

    public static int solution1(String haystack, String needle) {

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

    public static int solution2(String haystack, String needle) {
        // KMP算法
        // KMP算法的核心是利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的。
        // 具体实现就是通过一个next()函数实现，函数本身包含了模式串的局部匹配信息。
        // KMP算法的时间复杂度O(m+n)

        // next 数组存放的是当前长度下（以i指向位置为结尾的字符串）的 最长相同前、后缀 的长度
        int[] next = new int[needle.length()];

        // 中初始化指针i=1，用于遍历待比较的位置
        // j=0,指向相同前缀的末尾，i始终在j的后面
        for (int j = 0, i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1]; // 使 j 指向 相同前缀 的下一位置
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++; // 前缀长度+1，末尾右移
            }
            next[i] = j; // 记录该位置对应的 最长相同前、后缀 的长度
        }

        for (int i = 0, j = 0; i < haystack.length(); i++) {

            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串 haystack=");
        String haystack = sc.nextLine();
        haystack = haystack.substring(1, haystack.length() - 1);
        System.out.print("请输入一个字符串 needle=");
        String needle = sc.nextLine();
        needle = needle.substring(1, needle.length() - 1);
        System.out.println(solution2(haystack, needle));
    }
}
