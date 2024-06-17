/**
 * @author: Wxj
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符:I，V，X，L，C，D，M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如:数字 2 写做 II ，即为两个并列的 I 。
 * 12 写做 XII ，即为 X + II 。
 * 27 写做 XXVII ，即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * 题目数据保证输入是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内。
 * <p>输入描述:
 * MCMXCIV
 * <p>输出描述:
 * 1994
 */
package com.company.brush.enumeration;

import java.util.Scanner;

public class RomanToInt {
    public static int solution(String s) {

        int res = 0; // 结果
        s = s + " "; // 字符串末尾添加一位空格占位，方便后面比较   空字符串不行！！!长度=0！

        for (int i = 0; i < s.length() - 1; i++) { // 遍历有效位length-1
            if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                res -= 1; // I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9
            } else if (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                res -= 10; // X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90
            } else if (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                res -= 100; // C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
            } else
                switch (s.charAt(i)) {
                    case 'I':
                        res += 1; // I 表示 1
                        break;
                    case 'V':
                        res += 5; // V 表示 5
                        break;
                    case 'X':
                        res += 10; // X 表示 10
                        break;
                    case 'L':
                        res += 50; // L 表示 50
                        break;
                    case 'C':
                        res += 100; // C 表示 100
                        break;
                    case 'D':
                        res += 500; // D 表示 500
                        break;
                    case 'M':
                        res += 1000; // M 表示 1000
                        break;
                    default:
                        break;
                }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.print("请输入一个范围在[1,3999]的罗马数字：");

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solution(s));
    }
}
