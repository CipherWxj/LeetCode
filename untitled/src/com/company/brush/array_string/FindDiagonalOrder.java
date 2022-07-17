/**
 * @author: Wxj
 * 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>输入描述:
 * mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * <p>输出描述:
 * [1,2,4,7,5,3,6,8,9]
 */
package com.company.brush.array_string;

import java.util.Arrays;

public class FindDiagonalOrder {
    public static int[] solution(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] nums = new int[m * n];
        int sum = 0; // 横坐标 + 纵坐标 的和，每一条对角线和相等
        int i = 0; // 添加的索引
        // 因为最后会执行一次 sum++，所以终止条件是 m + n - 1
        while (sum < m + n - 1) {
            // 第 1， 3， 5 ... 条
            // 确定初始坐标
            int x1 = (sum < m) ? sum : m - 1; // 横坐标 尽量取最大
            int y1 = sum - x1; // 根据 和 确定纵坐标
            // 遍历对角线，不越界
            while (x1 >= 0 && y1 <= n - 1) {
                nums[i++] = mat[x1][y1];
                x1--;
                y1++;
            }
            // 遍历完该条对角线之后，sum++，遍历下一条
            sum++;
            if (sum >= m + n - 1) break;

            // 第 2 4 6 ... 条
            // 确定初始坐标
            int y2 = (sum < n) ? sum : n - 1; // 纵坐标 尽量取最大
            int x2 = sum - y2; // 根据 和 确定横坐标
            // 遍历对角线，不越界
            while (y2 >= 0 && x2 <= m - 1) {
                nums[i++] = mat[x2][y2];
                x2++;
                y2--;
            }
            // 遍历完该条对角线之后，sum++，遍历下一条
            sum++;
            // if (sum >= m + n - 1) break;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}})));
    }
}
