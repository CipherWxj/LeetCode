package com.company.brush.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangxinjian
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>输入描述:
 * numRows = 5
 * <p>输出描述:
 * [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class Generate {
    private static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        // 外层循环控制行数
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // 内层循环控制每行的列数
            for (int j = 0; j < i + 1; j++) {
                // 边界都是1
                if (j == 0 || j == i) {
                    row.add(1);
                } else { // 非边界递推
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
