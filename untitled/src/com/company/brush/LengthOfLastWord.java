/**
 * @author: Wxj
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。
 * 返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>输入描述:
 * s = "Hello World"
 * <p>输出描述:
 * 5
 */
package com.company.brush;

import java.util.Scanner;

public class LengthOfLastWord {
    public static int solution(String s) {
        int i = s.length() - 1; // 用于反向遍历的指针
        // 排除末尾空格
        while (s.charAt(i) == ' ') {
            i--;
        }
        int last = i; // 记录最后一个字母的位置
        // 遍历最后一个单词
        while (i > -1 && s.charAt(i) != ' ') { // 遍历到开头或者空格为止
            i--;
        }
        return last - i; // 返回单词长度
    }

    public static void main(String[] args) {
        System.out.println("请输入一个只含字母和空格的字符串：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //s = s.substring(1, s.length() - 1);
        System.out.println(solution(s));
    }
}
