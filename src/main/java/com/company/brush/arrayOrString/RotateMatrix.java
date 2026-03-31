package com.company.brush.arrayOrString;

import com.alibaba.fastjson.JSON;

/**
 * @author: wangxinjian
 * 48. 旋转图像
 * 给定一个 n×n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要 使用另一个矩阵来旋转图像。
 * <p>输入描述:
 * matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>输出描述:
 * [[7,4,1],[8,5,2],[9,6,3]]
 */
public class RotateMatrix {
    private static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        // 分块，依次交换元素
        // 要区分奇数和偶数，所以j的范围是[0, (n + 1) / 2)
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                // 数学坐标的对应关系，画图理解
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }
}
