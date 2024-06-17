/**
 * @author: Wxj
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数：正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>输入描述:
 * x = 121
 * <p>输出描述:
 * true
 */
package com.company.brush.enumeration;


import java.util.Scanner;

public class PalindromeInt {

    //将 x 转化为字符串比较字符
    public static boolean solution1(int x) {
        String s = Integer.toString(x); //将整数 x 转化为字符串
        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //直接比较各数位上的数是否相等
    public static boolean solution2(int x) {
        //x<0,返回false
        if (x < 0) {
            return false;
        }

        int power = 1; //初始化最高位位权
        int len = 1; //初始化位数
        while (x / power >= 10) { //这里如果是 >0 会溢出报错！！！
            power *= 10;
            len++;
        }

        for (int j = 0; j < len / 2; j++) {
            int left = x / power; //最左侧（最高位）上的数
            int right = x % 10; //最右侧（最低位）上的数
            if (left != right) {
                return false;
            }
            x = (x - left * power) / 10; //去除最高位和最低位得到新的 x
            power /= 100; //更新最高位位权
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x= ");
        int x = sc.nextInt();
        //System.out.println(solution1(x));
        System.out.println(solution2(x));
    }
}
