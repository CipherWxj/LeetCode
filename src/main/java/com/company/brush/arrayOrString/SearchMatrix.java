package com.company.brush.arrayOrString;

/**
 * @author: wangxinjian
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 mxn 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性:
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>输入描述:
 * matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * <p>输出描述:
 * true
 */
public class SearchMatrix {
    private static boolean searchMatrixWithBinarySearch(int[][] matrix, int target) {
        // 按行二分查找
        for (int[] row : matrix) {
            int left = 0, right = row.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        // 从左下角开始查找，左下角的数在整行是最小的，在整列是最大的
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) { // 大于目标值，排除整行
                i--;
            } else { // 小于目标值，排除整列
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 8;
        System.out.println(searchMatrixWithBinarySearch(matrix, target));
        System.out.println(searchMatrix(matrix, target));
    }
}
