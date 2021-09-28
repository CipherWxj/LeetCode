/**
 * @author: Wxj
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>输入描述：
 * s = abcabcbb
 * <p>输出描述：
 * 3
 * （解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3）
 */
package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatSubstring {

    public static int solution1(String s) {
        int flag = 0; //不重复字符的起始位置
        int length = 0; //子串长度
        int maxLength = 0; //最大子串的长度

        for (int i = 0; i < s.length(); i++) {
            int temp = s.indexOf(s.charAt(i), flag); //固定flag，i向右滑动，返回与flag位置右侧与索引i处相同的位置索引
            if (temp < i) {
                if (maxLength < length) {
                    maxLength = length; //更新子串最大长度
                }
                if (maxLength >= s.length() - 1 - temp) {
                    return maxLength; //最右侧小于现有最大子串长度的字符不用考虑
                }
                flag = temp + 1; //flag位置右移
                length = i - temp - 1;  //子串长度

            }
            length++; //子串长度自增
        }
        return length;
    }

    public static int solution2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0; //无重复的最长子串的长度

        //滑动窗口
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char newChar = s.charAt(right);
            right++; // 扩大窗口
            window.put(newChar, window.getOrDefault(newChar, 0) + 1); //处理窗口中新加入的元素 newChar
            //如果窗口中该元素重复，则缩小窗口直至不重复
            while (window.get(newChar) > 1) {
                char removeChar = s.charAt(left);
                left++; // 缩小窗口
                window.put(removeChar, window.get(removeChar) - 1); //处理下窗口被移除的元素 removeChar
            }
            //我们的窗口是左开右闭的，所以这里窗口的长度不要 +1 !!!
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("s=");
        String s = sc.nextLine();
        System.out.println(solution1(s));
        System.out.println(solution2(s));
    }
}

