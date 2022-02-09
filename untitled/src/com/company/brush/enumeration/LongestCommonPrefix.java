/**
 * @author: Wxj
 * 14. 最长公共前缀
 * 给你一个字符串数组 strs，查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 最长公共前缀：字符串数组中元素前几个字母是一样的。
 * <p>输入描述:
 * strs = ["flower","flow","flight"]
 * <p>输出描述:
 * "fl"
 */
package com.company.brush.enumeration;

import java.util.Scanner;

public class LongestCommonPrefix {

    public static String solution(String[] strs) {
        int j = 0; // 初始化比较的位数
        StringBuilder res = new StringBuilder(); // 初始化结果字符串
        while (j < strs[0].length()) { // 待比较的位数小于strs中第一个元素（字符串）的长度
            char temp = strs[0].charAt(j); // 取出第一个元素当前位的字符
            for (String str : strs) { // 依次遍历所有元素
                if (j >= str.length()) { // 判断长度是否超出
                    return res.toString();
                } else if (temp != str.charAt(j)) { // 字符不等返回，相等接着遍历
                    return res.toString();
                }
            }
            res.append(temp); // 将相同字符添加进结果字符串
            j++; // 待比较的位数右移
        }
        return res.toString();
    }

    public static void main(String[] args) {

        System.out.println("请输入一个字符串数组：");
        Scanner sc = new Scanner(System.in);
        System.out.print("strs=");
        String s = sc.nextLine();
        String s1 = s.substring(1, s.length() - 1);
        String[] strs = s1.split(",");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].substring(1, strs[i].length() - 1);
        }
        System.out.println(solution(strs));
    }
}
