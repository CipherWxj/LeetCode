/**
 * @author: Wxj
 * 判断字符串是否是 类回文串。
 * 类回文串：字符经过若干次移动，字符串能变成回文串。
 * 不区分字母大小写，其他字符同意当成 *。
 * <p>输入描述:
 * Aasd%￥s
 * <p>输出描述:
 * true
 */
package com.company.bishi;

import java.util.*;

public class IsSamePalindrome {
    public static boolean solution(String s) {
        int len = s.length();
        if (len < 2) return true;

        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (c[i] >= 97 && c[i] <= 122) {
                if (map.containsKey(c[i])) {
                    int value = map.get(c[i]);
                    map.put(c[i], ++value);
                } else {
                    map.put(c[i], 1);
                }
            } else if (c[i] >= 65 && c[i] <= 90) {
                char lowC = (char) (c[i] - 32);
                if (map.containsKey(lowC)) {
                    int value = map.get(lowC);
                    map.put(lowC, ++value);
                } else {
                    map.put(lowC, 1);
                }
            } else {
                map.put('*', ++count);
            }
        }

        int judge = 0;
        for (int value : map.values()) {
            if ((value & 1) == 1) {
                judge++;
            }
            if (judge > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
}
