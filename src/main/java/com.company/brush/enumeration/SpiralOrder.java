/**
 * @author: Wxj
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>输入描述:
 * matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>输出描述:
 * [1,2,3,6,9,8,7,4,5]
 */
package com.company.brush.enumeration;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static List<Integer> solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;

        List<Integer> list = new ArrayList<>();
        int numRow = matrix.length, numColumn = matrix[0].length;
        int left = 0, right = numColumn - 1, top = 0, bottom = numRow - 1;

        while (left <= right && top <= bottom) {
            // 上边界
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            // 右边界
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            // 这里的判断很重要！处理最后的中间元素
            // 想象成 如果最后还是个 方框，就去搜 四边； 如果不是 方框， 就只搜索 两边（其实只执行了一边）
            if (left < right && top < bottom) {
                // 下边界
                for (int j = right - 1; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                // 左边界
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
