/**
 * @author: Wxj
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>输入描述:
 * matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * <p>输出描述:
 * [[1,0,1],[0,0,0],[1,0,1]]
 */
package com.company.brush.array_string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class SetZeroes {
    public static void solution(int[][] matrix) {
        // 两个哈希表标记出现过0的行和列
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        // 第一次遍历，找到有0的行和列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        // 第二次遍历，将有0的行或列元素置0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowSet.contains(i) || columnSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void solution1(int[][] matrix) {
        // 【原地哈希】，用两个变量分别标识第一行和第一列是否有0，再用原矩阵第一行第一列标识每一行或每一列是否有0
        // 第一行
        boolean firstRowExistZero = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowExistZero = true;
                break;
            }
        }
        // 第一列
        boolean firstColumnExistZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnExistZero = true;
                break;
            }
        }
        // 除第一行和第一列以外，如果其他 行 或 列 有0，先将 第一列对应的行 或 第一行对应的列 置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 如果 第一行 或 第一列 有0，则将对应的 列 和 行 都置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 最后看第一行和第一列
        if (firstRowExistZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColumnExistZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution1(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }
}
