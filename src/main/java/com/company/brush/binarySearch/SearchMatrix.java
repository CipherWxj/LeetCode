/**
 * @author: wangxinjian
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>输入描述:
 * matrix = [[1,3,5,7],
 * [10,11,16,20],
 * [23,30,34,60]], target = 3
 * <p>输出描述:
 * true
 */
package com.company.brush.binarySearch;

public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        // 如果行不存在，返回 false
        if (row == -1) return false;
        // 二分查找对应的行
        int left = 0, right = matrix[row].length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // 二分查找行
    public static int searchRow(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 最后一次比较 mid = left = right，
        // 如果 matrix[mid][0] <= target，说明 target 可能在 matrix[mid] 中，返回 right；
        // 否则，说明 target 可能在 matrix[mid - 1] 中，执行right - 1，返回 right
        return right;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 16;
        System.out.println(searchMatrix(matrix, target));
    }
}
