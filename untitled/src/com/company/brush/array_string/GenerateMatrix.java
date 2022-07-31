/**
 * @author: Wxj
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>输入描述:
 * n = 3
 * <p>输出描述:
 * [[1,2,3],[8,9,4],[7,6,5]]
 */
package com.company.brush.array_string;

public class GenerateMatrix {
    public int[][] solution(int n) {
        int[][] res = new int[n][n];
        // 四个方向，右/下/左/上，  注意顺序！
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 行、列、方向索引
        int row = 0, column = 0, dirIndex = 0;
        // 遍历添加
        for (int num = 1; num <= n * n; num++) {
            res[row][column] = num; // 添加
            // 判断下一位置
            int nextRow = row + dirs[dirIndex][0];
            int nextColumn = column + dirs[dirIndex][1];
            // 如果超出边界，或者 下一位置已经填过数字了，更改方向
            if (nextRow < 0 || nextRow > n - 1 || nextColumn < 0 || nextColumn > n - 1 || res[nextRow][nextColumn] != 0) {
                dirIndex = (++dirIndex) % 4;
            }
            // 实际更新下一位置
            row += dirs[dirIndex][0];
            column += dirs[dirIndex][1];
        }
        return res;
    }
}
