/**
 * @author: Wxj
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>输入描述:
 * s = "cbaebabacd", p = "abc"
 * <p>输出描述:
 * [0,6]
 */
package com.company.brush.slidingwindow;

import java.util.*;

public class FindAnagrams {
    public static List<Integer> solution(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 标准集合
        Map<Character, Integer> pMap = new HashMap<>();
        // 初始化标准集合
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        // 窗口集合，记录窗口中满足条件的字符的出现次数
        Map<Character, Integer> windowMap = new HashMap<>();
        // 窗口左右边界 [left, right - 1]
        int left = 0, right = 0;
        // 有效字符数量，标识窗口中满足条件的字符的个数
        int validCharNum = 0;
        // 右边界遍历，扩大窗口范围
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            // 如果标准集中存在当前字符，先更新窗口集合，再更新有效字符数
            if (pMap.containsKey(cur)) {
                // 更新窗口集合中的字符数量
                windowMap.put(cur, windowMap.getOrDefault(cur, 0) + 1);
                // 如果窗口集合中某个字符的数量 = 标准集中的该字符数量，有效字符数+1
                if (windowMap.get(cur).equals(pMap.get(cur))) validCharNum++;

            }
            System.out.println(left + "**" + right);
            // 当 窗口长度 = 标准字符串的长度 时，判断并移动窗口
            while (right - left >= p.length()) {
                // 此时如果有效字符数量与标准集中的字符数量相等，那么窗口范围内的字符串就是一个异位词
                if (validCharNum == pMap.size()) res.add(left);
                // 被移出窗口的字符
                char leftChar = s.charAt(left);
                // 移动左侧边界，缩小窗口
                left++;
                // 如果被移出窗口的字符是标准集中的字符，先更新有效字符数，再更新窗口集合
                if (pMap.containsKey(leftChar)) {
                    // 如果窗口集合中某个字符的数量 = 标准集中的该字符数量，有效字符数量-1
                    if (windowMap.get(cur).equals(pMap.get(cur))) validCharNum--;
                    // 更新窗口集合
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        solution("cbaebabacd", "abc");
    }
}
