/**
 * @author: Wxj
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
package com.company.brush.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static String solution(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0, start = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            if (tMap.containsKey(cur)) {
                sMap.put(cur, sMap.getOrDefault(cur, 0) + 1);
                if (sMap.get(cur).equals(tMap.get(cur))) valid++;
            }

            while (valid == tMap.size()) {

                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char leftChar = s.charAt(left);
                left++;
                if (tMap.containsKey(leftChar)) {
                    if (sMap.get(leftChar).equals(tMap.get(leftChar))) valid--;
                    sMap.put(leftChar, sMap.getOrDefault(leftChar, 0) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(solution("ADOBECODEBANC", "ABC"));
    }
}
