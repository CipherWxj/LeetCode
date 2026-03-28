package com.company.brush.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangxinjian
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>输入描述:
 * s = "abcabcbb"
 * <p>输出描述:
 * 3
 */
public class LengthOfLongestSubstring {
    private static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) return s.length();
        int maxSubLen = 0;
        int start = 0;
        // 初始化哈希表，key：字符串s出现过的字符 value：字符最近一次出现的位置索引
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            // map里有当前字符，并且当前字符在窗口起始位置右侧，需要更新窗口起始位置
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            // 计算长度，注意+1
            maxSubLen = Math.max(maxSubLen, end - start + 1);
            // 不管map里有没有当前字符，都要更新字符最新出现的位置
            map.put(c, end);
        }
        return maxSubLen;
    }

    public static void main(String[] args) {
        String s1 = "tmmzuxt";
        String s2 = "abcabcbb";
        String s3 = "pwwkew";
        String s4 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
    }
}
