/**
 * @author: Wxj
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 * <p>输入描述:
 * num1 = "11", num2 = "123"
 * <p>输出描述:
 * "134"
 */
package com.company.brush.math;

import java.util.Scanner;

public class AddStrings {
    public static String solution(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int car = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < Math.max(n1, n2); i++) {
            int x = (n1 - i > 0) ? num1.charAt(n1 - 1 - i) - '0' : 0;
            int y = (n2 - i > 0) ? num2.charAt(n2 - 1 - i) - '0' : 0;
            int sum = x + y + car;
            res.append(sum % 10);
            car = sum / 10;
        }
        if (car != 0) res.append(car);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("num1= ");
        String num1 = sc.nextLine();
        System.out.print("num2= ");
        String num2 = sc.nextLine();
        System.out.println(solution(num1,num2));
    }
}
