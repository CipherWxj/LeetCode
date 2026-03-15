/**
 * @author: Wxj
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>输入描述:
 * s1 = "ab", s2 = "eidbaooo"
 * <p>输出描述:
 * true
 */
package com.company.brush.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public static boolean solution(String s1, String s2) {
        // 标准集合
        Map<Character, Integer> standardMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            standardMap.put(c, standardMap.getOrDefault(c, 0) + 1);
        }
        // 窗口集合，记录窗口中满足条件的字符的出现次数
        Map<Character, Integer> windowMap = new HashMap<>();
        // 窗口左右边界 [left, right - 1)
        int left = 0, right = 0;
        // 有效字符数量，标识窗口中满足条件的字符的个数
        int validCharNum = 0;
        // 右边界遍历，扩大窗口范围
        while (right < s2.length()) {
            char cur = s2.charAt(right);
            right++;
            // 如果标准集中存在当前字符，先更新窗口集合，再更新有效字符数
            if (standardMap.containsKey(cur)) {
                windowMap.put(cur, windowMap.getOrDefault(cur, 0) + 1);
                if (windowMap.get(cur).equals(standardMap.get(cur))) validCharNum++;
            }
            // 当 窗口长度 = 标准字符串的长度 时，判断并移动窗口
            while (right - left >= s1.length()) {
                // 此时如果有效字符数量与标准集中的字符数量相等，那么窗口范围内的字符串就是一个有效排列
                if (validCharNum == standardMap.size()) return true;
                char leftChar = s2.charAt(left);
                left++;
                // 如果被移出窗口的字符是标准集中的字符，先更新有效字符数，再更新窗口集合
                if (standardMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).equals(standardMap.get(leftChar))) validCharNum--;
                    windowMap.put(leftChar, windowMap.getOrDefault(leftChar, 0) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solution("ab", "eidbaooo");
    }
}
