package com.company.brush.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangxinjian
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>输入描述:
 * s = "cbaebabacd", p = "abc"
 * <p>输出描述:
 * [0,6]
 */
public class FindAnagrams {
    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        // 初始化目标字符串的哈希表，key：目标字符串中存在的字符，value：字符出现的次数
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            targetMap.put(p.charAt(i), targetMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        // 初始化遍历子串的哈希表，key：字符串中存在的字符，value：字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        // 起始和结束位置，初始化都为0
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            // 遍历到目标字符串中不存在的字符，直接看下一位
            if (!targetMap.containsKey(c)) {
                // 需要把map里存在的字符数量减掉，当前end位置是不存在的字符，不用管
                while (start < end) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                }
                // 起始和结束位置都从下一位开始重新计算
                start++;
                end++;
                continue;
            }

            // 当前字符在子串中的数量（不包含当前end位置）
            int cExistsNum = map.getOrDefault(c, 0);
            // 子串中当前字符的数量已经与目标字符串中字符的数量，更新起始位置
            if (cExistsNum == targetMap.get(c)) {
                // 直到子串中第一次出现当前字符，左侧的字符在map中的数量都要减掉
                while (c != s.charAt(start)) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                }
                // 更新起始位置
                start++;
            } else { // 子串中当前字符的数量 小于 目标字符串中字符的数量，当前end位置的数量加进去，加1
                map.put(c, cExistsNum + 1);
            }

            // 如果子串长度等于目标字符串的长度，将起始位置放到结果List里，起始位置右移一位
            if (end - start + 1 == len) {
                res.add(start);
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            // 每次结束位置都右移
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
