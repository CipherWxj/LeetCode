/**
 * @author: Wxj
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>输入描述:
 * a = "11", b = "1"
 * <p>输出描述:
 * "100"
 */
package com.company.brush.enumeration;

import java.util.Scanner;

public class AddBinary {

    public static String solution(String a, String b) {
        // 使两个字符串等长
        if (a.length() > b.length()) {
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = 0; i < a.length() - b.length(); i++) {
                bBuilder.insert(0, "0");
            }
            b = bBuilder.toString();
        } else {
            StringBuilder aBuilder = new StringBuilder(a);
            for (int i = 0; i < b.length() - a.length(); i++) {
                aBuilder.insert(0, "0");
            }
            a = aBuilder.toString();
        }

        StringBuilder res = new StringBuilder(new StringBuilder()); // 结果存储串
        char c = '0'; // 模拟进位

        // 笨蛋枚举，通俗易懂
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0' && c == '0') {
                res.insert(0, "0");
                c = '0';
            } else if (a.charAt(i) == '0' && b.charAt(i) == '0' && c == '1') {
                res.insert(0, "1");
                c = '0';
            } else if (a.charAt(i) == '0' && b.charAt(i) == '1' && c == '0') {
                res.insert(0, "1");
                c = '0';
            } else if (a.charAt(i) == '0' && b.charAt(i) == '1' && c == '1') {
                res.insert(0, "0");
                c = '1';
            } else if (a.charAt(i) == '1' && b.charAt(i) == '0' && c == '0') {
                res.insert(0, "1");
                c = '0';
            } else if (a.charAt(i) == '1' && b.charAt(i) == '0' && c == '1') {
                res.insert(0, "0");
                c = '1';
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1' && c == '0') {
                res.insert(0, "0");
                c = '1';
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1' && c == '1') {
                res.insert(0, "1");
                c = '1';
            }
        }
        // 最终进位为1，则添加进字符串
        if (c == '1') {
            res.insert(0, "1");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("请输入两个只含0和1的字符串：");
        Scanner sc = new Scanner(System.in);
        System.out.print("a= ");
        String a = sc.nextLine();
        System.out.print("b= ");
        String b = sc.nextLine();
        System.out.println(solution(a, b));
    }
}
