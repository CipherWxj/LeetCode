/**
 * @author: Wxj
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>输入描述:
 * nums1 = [1,2], nums2 = [3,4]
 * <p>输出描述:
 * 2.50000
 */
package com.company.brush.search.binarysearch;

import java.util.Scanner;

public class FindMedianSortedArrays {

    public static double solution(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        int i = 0, j = 0;
        int left = 0, right = 0;
        for (int k = 0; k <= n / 2; k++) {
            left = right;
            if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                right = nums1[i++];
            } else if (j < n2 && (i >= n1 || nums1[i] >= nums2[j])) {
                right = nums2[j++];
            }
        }
        if ((n & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nums1= ");
        String s1 = sc.nextLine();
        int[] nums1 = input(s1);
        System.out.print("nums2= ");
        String s2 = sc.nextLine();
        int[] nums2 = input(s2);
        System.out.println(solution(nums1, nums2));
    }

    public static int[] input(String s) {
        s = s.substring(1, s.length() - 1);
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        return nums;
    }
}
