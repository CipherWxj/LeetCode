/**
 * @author: Wxj
 * 718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>输入描述:
 * nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * <p>输出描述:
 * 3
 */
package com.company.brush.dynamicprogramming;
/*
 * 方法1：动态规划 com/company/brush/dynamicprogramming/FindLength.java
 * 方法2：滑动窗口 com/company/brush/slidingwindow/FindLength.java
 */
public class FindLength {
    public static int solution(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        // 二维动态数组
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 记录最大值
        int max = 0;

        // 初始条件：左上边界全为0，初始化省略了
        // 遍历
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 因为要保证顺序连续，否则重新开始计数
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    // 优化空间复杂度，将二维数组变成一维数组
    public static int solution1(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        // 一维动态数组
        int[] dp = new int[len2 + 1];
        // 记录最大值
        int max = 0;

        // 初始条件：左上边界全为0，初始化省略了
        // 遍历
        for (int i = 1; i <= len1; i++) {
            // 每一行 从右往左 比较
            // dp[]的更新也是从右往左，恰好利用的dp[j-1]是上一行的状态
            for (int j = len2; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    // 因为要保证顺序连续，否则重新开始计数
                    dp[j] = 0;
                }
                max = Math.max(dp[j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};
        System.out.println(solution(nums1, nums2));
    }
}
