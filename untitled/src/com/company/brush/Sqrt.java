/**
 * @author: Wxj
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>输入描述:
 * x = 8
 * <p>输出描述:
 * 2
 */
package com.company.brush;

import java.util.Scanner;

public class Sqrt {
    public static int solution(int x) {
        // 0和1单独考虑
        if (x == 0) return 0;
        if (x == 1) return 1;
        // 以[0,x]作为起始区间，二分法查找
        int left = 0;
        int right = x;
        return search(x, left, right);
    }

    // 二分法查找
    public static int search(int x, int left, int right) {
        // 中间值
        int mid = left + (right - left) / 2;
        // 返回条件
        // 用除法代替乘法，防止溢出！！！
        if ((x / mid) >= mid && (x / (mid + 1) < (mid + 1))) {
            return mid;
        }
        if ((x / mid) > mid) left = mid;
        if ((x / mid) < mid) right = mid;
        return search(x, left, right); // 递归
    }

    public static void main(String[] args) {
        System.out.println("请输入一个非负整数：");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(solution(x));
    }
}
