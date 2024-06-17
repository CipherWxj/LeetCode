/**
 * @author: Wxj
 * 718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>输入描述:
 * nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * <p>输出描述:
 * 3
 */
package com.company.brush.slidingwindow;
/*
 * 方法1：动态规划 com/company/brush/dynamicprogramming/FindLength.java
 * 方法2：滑动窗口 com/company/brush/slidingwindow/FindLength.java
 */
public class FindLength {
    public static int solution(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int max = 0;
        // 开始将 nums1 的最后一位与 nums2 的第一位对齐，固定nums2，依次后移 nums1
        // 直到 nums1 的第一位与 nums2 的第一位对齐
        for (int i = len1 - 1; i > 0; i--) {
            // 有效长度（窗口）就是对齐的位数
            int len = Math.min(len2, len1 - i);
            // 将对齐的位数比较，得到相同的子串
            int maxLen = maxLength(nums1, nums2, i, 0, len);
            max = Math.max(max, maxLen);
        }
        // 开始将 nums1 的第一位与 nums2 的第一位对齐，固定nums1，依次前移 nums2（相当于固定nums2，后移nums1）
        // 直到 nums1 的第一位与 nums2 的最后一位对齐
        for (int i = 0; i < len2; i++) {
            int len = Math.min(len1, len2 - i);
            int maxLen = maxLength(nums1, nums2, 0, i, len);
            max = Math.max(max, maxLen);
        }
        return max;
    }

    // 比较窗口内数，得到重复字串
    public static int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int maxLen = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            maxLen = Math.max(maxLen, k);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};
        System.out.println(solution(nums1, nums2));
    }
}
