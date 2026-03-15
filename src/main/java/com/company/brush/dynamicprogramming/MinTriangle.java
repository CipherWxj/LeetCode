/**
 * @author: Wxj
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>输入描述：
 * triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * <p>输出描述:
 * 11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
package com.company.brush.dynamicprogramming;

import java.util.List;

public class MinTriangle {
    public int solution(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        // dp[i][j] 表示到达从上往下 第 i 行、从左往右第 j 列位置时的最小路径和
        int[][] dp = new int[n][m];
        // 初始值
        dp[0][0] = triangle.get(0).get(0);
        // 从上往下遍历
        for (int i = 1; i < n; i++) {
            // 从左往右遍历
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 最左侧只有一条路径
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    // 最右侧只有一条路径
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    // 两条取最小的
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        // 遍历得到最后一行最小值
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(dp[n - 1][i], ans);
        }
        return ans;
    }

    // 空间优化，上一行的数据多余了
    public int solution1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}
