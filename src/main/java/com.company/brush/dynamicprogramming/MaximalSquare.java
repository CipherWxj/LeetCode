/**
 * @author: Wxj
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>输入描述:
 * matrix = [["1","0","1","0","0"],["1","0","1","1","1"],
 *           ["1","1","1","1","1"],["1","0","0","1","0"]]
 * <p>输出描述:
 * 4
 */
package com.company.brush.dynamicprogramming;

public class MaximalSquare {
    public static int solution(char[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        // 最大值（边长） 不要像个傻逼一样用double型每次都把面积计算出来……
        int max = 0;
        // 二维动态数组，dp[i][j]记录以matrix[i][j]为右下角的正方形的最大边长
        int[][] dp = new int[m][n];
        // 边界条件
        // 上边界
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1'){
                dp[0][j] = 1;
                max = 1;
            }else {
                dp[0][j] = 0;
            }
        }
        // 左边界
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }else {
                dp[i][0] = 0;
            }
        }

        // 递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 为’0‘直接记为0
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                // 为’1‘则考虑与它相邻的左、上、左上这三个位置
                }else if(dp[i - 1][j - 1] != 0 && dp[i - 1][j] != 0 && dp[i][j - 1] != 0){
                    // 三个位置全不为0，则为  最小值+1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }else {
                    // 若有一个位置为0，则为  1（本身）
                    dp[i][j] = 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        // 最后返回面积=边长*边长
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        System.out.println(solution(matrix));
    }
}
