package com.company.brush.arrayOrString;

import com.alibaba.fastjson.JSON;

/**
 * @author: wangxinjian
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>输入描述:
 * matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * <p>输出描述:
 * [[1,0,1],[0,0,0],[1,0,1]]
 */
public class SetZeroes {
    private static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 记录第一列是否有0，有则为true
        boolean firstColumnHasZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstColumnHasZero = true;
        }
        // 记录第一行是否有0，有则为true
        boolean firstRowHasZero = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) firstRowHasZero = true;
        }
        // 遍历除第一行和第一列外的其他元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果等于0，用第一行和第一列标记该行该列有0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 根据第一行和第一列的标记，将对应行或列置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 最后处理第一行和第一列的元素
        if (firstColumnHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }
}
