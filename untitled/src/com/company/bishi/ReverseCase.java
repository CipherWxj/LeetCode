/**
 * @author: Wxj
 * 长度为 你的字符串，做 q 次操作，选择区间翻转字母大小写。
 * <p>输入描述:
 * 5 3
 * asdfg
 * 1 3
 * 3 5
 * 4 5
 * <p>输出描述:
 * ASdfg(asdfg--ASDfg--ASdFG--ASdfg)
 */
package com.company.bishi;

import java.util.Scanner;

public class ReverseCase {
    public static String solution(String s, int n, int q, int[] l, int[] r) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < q; i++) {
            chars = reverse(chars, l[i], r[i]);
        }
        return String.valueOf(chars);
    }

    public static char[] reverse(char[] chars, int l, int r) {
        for (int j = l - 1; j < r; j++) {
            if (chars[j] >= 65 && chars[j] <= 90) {
                chars[j] = (char) (chars[j] + 32);
            } else {
                if (chars[j] >= 97 && chars[j] <= 122) {
                    chars[j] = (char) (chars[j] - 32);
                }
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        //String none = sc.nextLine();
        String s = sc.nextLine();
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i = 0; i < q; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }
        System.out.println(solution(s, n, q, l, r));
    }
}
