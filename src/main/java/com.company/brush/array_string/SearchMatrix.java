/**
 * @author: Wxj
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 mxn 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性:
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>输入描述:
 * matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * <p>输出描述:
 * true
 */
package com.company.brush.array_string;

public class SearchMatrix {
    // 暴力遍历
    public static boolean solution(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == target) return true;
            }
        }
        return false;
    }

    // 二分查找
    public static boolean solution1(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int left = 0, right = row.length - 1;
            // 逼近最后一个值，取等号
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    // z字型遍历
    public static boolean solution2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        // 从右上角开始！这是最巧妙的！
        // 右上角的值，在某一行是最大的，在某一列是最小的
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) { // 所有位于第 i 行的元素都是严格小于 target，往更大的找，i++
                i++;
            } else { // 所有位于第 j 列的元素都是严格大于 target，往更小的找，j--
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
    }
}
