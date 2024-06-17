/**
 * @author: Wxj
 * 48. 旋转图像
 * 给定一个 n×n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要 使用另一个矩阵来旋转图像。
 * <p>输入描述:
 * matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>输出描述:
 * [[7,4,1],[8,5,2],[9,6,3]]
 */
package com.company.brush.array_string;

public class Rotate {
    public void solution(int[][] matrix) {
        int len = matrix.length;
        // 沿主对角线做轴对称翻转
        for(int i = 0; i < len; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 沿竖对称轴做轴对称翻转
        for(int n = 0; n < len; n++){
            for(int m = 0; m < len / 2; m++){
                int temp = matrix[n][m];
                matrix[n][m] = matrix[n][len - 1 - m];
                matrix[n][len - 1 - m] = temp;
            }
        }
//		// 沿横对称轴做轴对称翻转
//		for(int n = 0; n < len; n++){
//            for(int m = 0; m < len / 2; m++){
//                int temp = matrix[m][n];
//                matrix[m][n] = matrix[len - 1 - m][n];
//                matrix[len - 1 - n][m] = temp;
//            }
//        }
    }
}
