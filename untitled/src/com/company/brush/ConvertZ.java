/**
 * @author: Wxj
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>输入描述:
 * s = PAYPALISHIRING, numRows = 3
 * <p>输出描述:
 * PAHNAPLSIIGYIR
 */
package com.company.brush;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertZ {

    public static String solution(String s, int numRows) {
        if (numRows == 1) return s; //一行

        //初始化一个numRows个StringBuilder的List容器
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) res.add(new StringBuilder());


        boolean direction = false; //方向，false：下；true：上
        int curRow = 0; //当前行

        for (char c : s.toCharArray()) { //遍历字符串s
            res.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                direction = !direction; //第1行和最后一行反向
            }
            curRow = direction ? (curRow + 1) : curRow - 1; //向下行递增，向上行递减
        }

        StringBuilder rows = new StringBuilder();
        for (StringBuilder row : res) {
            rows.append(row); //从上到下遍历行
        }
        return rows.toString(); //返回字符串
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("s= ");
        String s = sc.nextLine();
        System.out.print("numRows= ");
        int numRows = sc.nextInt();
        System.out.println(solution(s, numRows));
    }
}
