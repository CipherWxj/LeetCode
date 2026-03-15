/**
 * @author: Wxj
 * 补充题. 回到原点
 * 圆环上有 m 个点，编号为 0 ~ m - 1。从 0 点出发，每次可以逆时针和顺时针走一步，问走 n 步回到 0 共有多少种走法。
 * <p>输入描述:
 * m = 9, n = 2
 * <p>输出描述:
 * 2
 * 解释：有 2 种方案，分别是 0->1->0 和 0->9->0
 */
package com.company.brush.dynamicprogramming;

public class BackOrigin {
    public static int solution(int m, int n) {
        // dp[i][j]表示 走 j 步 到 第 i 个点的方案种数
        int[][] dp = new int[m][n + 1];
        // 初始条件
        // 开始位于 0 点，所以走 0 步仍在原点，记为 1 种方案
        dp[0][0] = 1;
        // 走 0 步到达其他位置不可能，都记为 0
        for (int i = 1; i < m; i++) {
            dp[i][0] = 0;
        }

        // 递推关系：
        // 走 j 步 到达 第 i 个点，取决于 走 j - 1 步 到达 第 i - 1 和 第 i + 1 个点的和
        // 到达这两个点再走 1 步就能到 第 i 个点
        // 二维矩阵的 V型相加 递推
        for (int j = 1; j < n + 1; j++) {
            for (int i = 0; i < m; i++) {
                // 左右边界循环，所以溢出部分取余
                dp[i][j] = dp[(i - 1 + m) % m][j - 1] + dp[(i + 1) % m][j - 1];
            }
        }
        return dp[0][n];
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 4));
    }
}
