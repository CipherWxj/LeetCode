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
import java.util.Scanner;

public class MinWindow {
    public static String solution(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) return "";
        // 分别记录字符串s、t中的字符个数
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();
        // 将 t 中的所有字符标记记录
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 初始化包含 t 中所有元素的子串
        String res = "";
        // count 表示 s.substring(start, end + 1)中包含 t 中字符的个数
        // resLen 表示 包含t中所有字符的子串的最小长度
        int count = 0, resLen = Integer.MAX_VALUE;
        // 滑动窗口的起止位置
        int start = 0, end;
        for (end = 0; end < s.length(); end++) {
            // 记录 s 中的字符
            mapS.put(s.charAt(end), mapS.getOrDefault(s.charAt(end), 0) + 1);
            // 有效字符
            // t 中存在，且已经遍历的 s 中该字符的个数 比 t 中 少
            if (mapT.containsKey(s.charAt(end)) && mapS.get(s.charAt(end)) <= mapT.get(s.charAt(end))) {
                count++;
            }
            // 更新窗口的起始位置
            // t 中不含起始位置字符（保证start<=end），或者 起始位置字符多余
            while (start < end && (!mapT.containsKey(s.charAt(start)) || mapS.get(s.charAt(start)) > mapT.get(s.charAt(start)))) {
                mapS.put(s.charAt(start), mapS.get(s.charAt(start)) - 1);
                start++;
            }
            // 找到包含 t中所有字符的子串，记录该子串及其长度
            // 后续一直遍历到s结尾，如果符合条件的子串长度更小，则更新
            if (count == t.length() && end - start + 1 < resLen) {
                resLen = end - start + 1;
                res = s.substring(start, end + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(solution(s, t));
    }
}
