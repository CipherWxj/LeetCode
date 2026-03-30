package com.company.brush.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangxinjian
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>输入描述:
 * s = "ADOBECODEBANC", t = "ABC"
 * <p>输出描述:
 * "BANC"
 */
public class MinWindow {
    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        // 初始化目标字符串哈希表，key：目标字符串中t存在的字符，value：字符出现的次数
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        // 初始化遍历子串的哈希表，key：滑动窗口字符串中在目标字符串中存在的字符，value：字符出现的次数
        Map<Character, Integer> windowMap = new HashMap<>();
        // 初始化覆盖子串的长度，起始和结束位置，最小长度初始化为最大值
        int minlen = Integer.MAX_VALUE, left = -1, right = -1;
        // 初始化滑动窗口的起始和结束位置
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            // 直到当前字符在目标字符串中存在，更新子串哈希表
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            }
            // 如果滑动窗口子串覆盖了目标字符串
            if (containsAllCharacters(windowMap, targetMap)) {
                // 更新起始位置，避免不存在的字符 或 字符出现多次
                while (!windowMap.containsKey(s.charAt(start)) || windowMap.get(s.charAt(start)) > targetMap.get(s.charAt(start))) {
                    // 字符出现多次时，需要更新窗口map
                    if (windowMap.containsKey(s.charAt(start))) {
                        windowMap.put(s.charAt(start), windowMap.get(s.charAt(start)) - 1);
                    }
                    start++;
                }
                // 直到[start, end]是覆盖子串，比较长度，是最小长度的覆盖子串，更新最小覆盖子串起始位置、结束位置、最小长度
                if (end - start + 1 < minlen) {
                    left = start;
                    right = end;
                    minlen = right - left + 1;
                }
            }
            end++;
        }
        // 如果没有找到覆盖子串，返回空字符串
        return left == -1 ? "" : s.substring(left, right + 1);
    }

    private static boolean containsAllCharacters(Map<Character, Integer> windowMap, Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            // 如果窗口中字符出现次数小于目标字符串中字符出现次数，返回false，大于等于认为全覆盖，返回true
            if (windowMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
