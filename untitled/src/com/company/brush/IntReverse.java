/**
 * @author: Wxj
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>输入描述:
 * x = 123
 * <p>输出描述:
 * 321
 */
package com.company.brush;

import java.util.Scanner;

public class IntReverse {

    public static int solution(int x) {

        int res = 0; // 结果存储

        // 数学方法
        while (x != 0) {
            int endNum = x % 10; // 对10取模得到末尾数字
            // 环境不允许存储64位的数，所以要在计算过程中判断是否溢出
            if (res > Integer.MAX_VALUE / 10 || (endNum > 7 && res == Integer.MAX_VALUE / 10)) { // 2^31-1 = 2147483647
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (endNum < -8 && res == Integer.MIN_VALUE / 10)) { // -2^31 = -2147283648
                return 0;
            }
            res = res * 10 + endNum; // 结果
            x = x / 10; // 取整得到高位数字
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("反转后的结果为：" + solution(x));
    }
}