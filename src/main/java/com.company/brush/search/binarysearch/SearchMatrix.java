/**
 * @author: Wxj
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
package com.company.brush.search.binarysearch;

public class SearchMatrix {
    public boolean solution(int[][] matrix, int target) {
        // 找到目标值可能存在的 行
        int row = binSearchRow(matrix, target);
        // 左边界不存在
        if (row < 0) return false;
        // 在可能存在的行 找目标值
        return binSearchTarget(matrix[row], target);
    }

    public int binSearchRow(int[][] matrix, int target) {
        // 左开右闭区间
        int left = -1, right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right + 1 - left) / 2; // +1 因为初始 left = -1
            if (matrix[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 左闭右开区间上的二分法
    public boolean binSearchTarget(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}
