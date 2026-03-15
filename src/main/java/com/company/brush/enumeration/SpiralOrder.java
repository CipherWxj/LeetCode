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

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public static List<Integer> solution(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        // 初始化最外圈上下左右四条线
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        // 逐渐向内圈缩小
        while (left <= right && top <= bottom) {
            // 顺时针
            // 先遍历最上边一行，从左上顶点开始遍历，右上顶点放到下面最右列遍历
            for (int r = left; r < right; r++) {
                res.add(matrix[top][r]);
            }
            // 再遍历最右边一列，从右上顶点开始遍历，因为有下面的if，右下顶点也要遍历到，避免只剩一行或一列时少遍历
            for (int b = top; b <= bottom; b++) {
                res.add(matrix[b][right]);
            }
            // 为了兼容最内圈只剩一行或者一列的情况，防止重复遍历
            if (left < right && top < bottom) {
                // 再遍历最下边一行，从右下顶点左侧元素开始遍历，左下顶点放到最左列遍历
                for (int l = right - 1; l > left; l--) {
                    res.add(matrix[bottom][l]);
                }
                // 最后遍历最左边一列，从左下顶点开始遍历，左上顶点已经遍历过了，不用遍历
                for (int t = bottom; t > top; t--) {
                    res.add(matrix[t][left]);
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
        System.out.println(JSON.toJSONString(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
