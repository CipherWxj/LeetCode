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
    public static boolean solution(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;

//        // 暴力遍历
//        for (int[] ints : matrix) {
//            for (int j = 0; j < n; j++) {
//                if (ints[j] == target) return true;
//            }
//        }
//        return false;
//
//        // 对行二分
//        for(int[] ints : matrix){
//            int l = 0, r = n - 1;
//            while (l < r){
//                int mid = l + (r - l) / 2;
//                if(ints[mid] == target) return true;
//                if (ints[r] < target) break;
//                if (ints[mid] < target){
//                    l = mid + 1;
//                }else {
//                    r = mid;
//                }
//            }
//        }
//        return false;

        if(n == 0) return false;
        // 右上角开始
        int i = 0, j = n - 1;
        while (i < m && j >= 0){
            if(matrix[i][j] < target){
                i++; // 一行最右边值都比 target 小，那么这一行都比target 小，排除（大于行最大值）
            }else if (matrix[i][j] > target){
                j--; // 一列最上边值都比 target 大，那么这一行都比target 大，排除（小于列最小值）
            }else {
                return true; // 相等，找到了
            }
        }
        return false; // 没找到
    }
}
