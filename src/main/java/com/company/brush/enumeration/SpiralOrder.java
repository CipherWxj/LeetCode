package com.company.brush.enumeration;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangxinjian
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>输入描述:
 * matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>输出描述:
 * [1,2,3,6,9,8,7,4,5]
 */
public class SpiralOrder {
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        // 上下左右的边界
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            // 遍历最上层的行，一整行，避免只有一个元素时未遍历到
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 遍历最右边的列，除第一行最后一列的元素外全部遍历
            for (int j = top + 1; j <= bottom; j++) {
                res.add(matrix[j][right]);
            }
            // 上、右边界遍历完后，需要判断下、左边界是否与上右边界重合，避免重复遍历
            if (top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            if (left < right) {
                for (int j = bottom; j > top; j--) {
                    res.add(matrix[j][left]);
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(JSON.toJSONString(spiralOrder(matrix)));
    }
}
