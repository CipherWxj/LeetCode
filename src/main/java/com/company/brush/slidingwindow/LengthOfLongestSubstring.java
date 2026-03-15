/**
 * @author: Wxj
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>输入描述:
 * s = "abcabcbb"
 * <p>输出描述:
 * 3
 */
package com.company.brush.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LengthOfLongestSubstring {
    public static int solution(String s) {
        // 初始化一个哈希表，key：出现过的字符，value：字符最后一次出现的位置索引
        Map<Character, Integer> appearedMap = new HashMap<>();
        // 初始化滑动窗口的左右指针，左指针标记起始位置，右指针遍历，滑动窗口标记的就是符合条件的子串
        int left = 0, right = 0;
        // 结果
        int subMaxLength = 0;

        while (right < s.length()) {
            // 当前字符
            Character curChar = s.charAt(right);

            // 如果当前遍历位置的字符出现过，分情况更新左边界
            // （1）再次出现的字符在窗口以外（左边界左边），那么左边界无需更新
            // （1）再次出现的字符在窗口以内（左边界右边），左边界就要更新为curChar上一次出现的位置的右边一位
            if (appearedMap.containsKey(curChar)) {
                left = Math.max(left, appearedMap.get(curChar) + 1);
            }
            // 当前遍历位置的字符记录到appearedMap里，之前出现过就更新索引位置，之前没出现过就放进去
            appearedMap.put(curChar, right);
            // 更新无重复字符的最长子串的长度
            subMaxLength = Math.max(subMaxLength, right - left + 1);
            // 遍历
            right++;
        }
        return subMaxLength;
    }

    public static int solution1(String s) {
        int res = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            char cur = s.charAt(right);
            windowMap.put(cur, windowMap.getOrDefault(cur, 0) + 1);
            right++;
            while (windowMap.get(cur) > 1) {
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        System.out.print("s= ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        System.out.println(solution1(s));
    }
}
