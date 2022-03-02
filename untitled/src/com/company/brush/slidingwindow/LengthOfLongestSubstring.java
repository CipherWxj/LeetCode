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
        // 使用hashMap记录出现过的字符
        // key：字符    value：最近出现的位置
        Map<Character, Integer> appeared = new HashMap<>();

        int left = -1, right = 0; // 窗口左、右位置
        int max = 0; // 最大子串长度

        for (right = 0; right < s.length(); right++) {
            // 字符已经存在
            if (appeared.containsKey(s.charAt(right))) {
                // 判断左指针是否更改位置
                left = Math.max(left, appeared.get(s.charAt(right)));
            }
            // 更新Map
            appeared.put(s.charAt(right), right);
            // 更新最大字串长度（窗口长度）
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        System.out.print("s= ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        System.out.println(solution(s));
    }
}
