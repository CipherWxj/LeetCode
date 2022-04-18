/**
 * @author: Wxj
 * 151. 颠倒字符串中的单词
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>输入描述:
 * s = the sky is blue
 * <p>输出描述:
 * blue is sky the
 */
package com.company.brush.array_string;

import java.util.Scanner;

public class ReverseWords {
    // 调用字符串操作函数实现
    public static String solution1(String s) {
        // 去除首尾空格
        s = s.trim();
        // 按空格分割，正则表达 \:转义  \s:空格  +:一个或多个
        String[] strArr = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        // 重新拼接
        for (int i = strArr.length - 1; i >= 0; i--) {
            res.append(strArr[i]);
            // 最后末尾不添加空格
            if (i != 0) res.append(" ");
        }

        return res.toString();
    }

    // 自己写函数功能
    // JAVA 字符串不可变，空间复杂度O(n)；对于字符串可变的语言（c++），则不需要再额外开辟空间，复杂度O(1)
    public static String solution2(String s) {
        // 去除首尾空格
        s = removeSpaces(s);
        System.out.println(s);
        // 去除中间多余空格
        StringBuilder sB = splitWords(s);
        System.out.println(sB);
        // 整个反转
        sB = reverse(sB, 0, sB.length() - 1);
        System.out.println(sB);
        // 按空格分割单个单词，单个单词再反转
        sB = reverseWord(sB);
        System.out.println(sB);

        return sB.toString();
    }

    // 去除首尾空格
    public static String removeSpaces(String s) {
        int start = 0, end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        return s.substring(start, end + 1);
    }

    // 去除中间多余空格
    public static StringBuilder splitWords(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                res.append(s.charAt(i));
            // 如果原字符串遍历到空格，转换思路看新字符串
            // 新字符串末尾没有空格添加一个，有了就不管了
            } else if (res.charAt(res.length() - 1) != ' ') {
                res.append(' ');
            }
        }
        return res;
    }

    // 反转（交换字符）
    public static StringBuilder reverse(StringBuilder s, int left, int right) {
        while (left < right) {
            char temp = s.charAt(left);
            s.setCharAt(left++, s.charAt(right));
            s.setCharAt(right--, temp);
        }
        return s;
    }

    // 单词反转
    public static StringBuilder reverseWord(StringBuilder s) {
        int start = 0, end = 0;
        while (end < s.length()) {
            // 寻找单个单词的首尾位置
            while (end < s.length() && s.charAt(end) != ' ') end++;
            reverse(s, start, end - 1);
            // 继续寻找下一个单词
            end++;
            start = end;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution2(sc.nextLine()));
    }
}
