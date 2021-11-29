/**
 * @author: Wxj
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>输入描述:
 * nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * <p>输出描述:
 * [1,2,2,3,5,6]
 */
package com.company.brush;

import java.util.Arrays;
import java.util.Scanner;

public class MergeOrderedArrays {

    public static int[] solution(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0; // 索引指针

        while (j < n) { // nums2中全部整数都与nums1中比较完则退出循环
            if (nums1[i] <= nums2[j]) {
                if (i == m + j) { // 遍历到nums1中有效整数的尾部
                    nums1[m + j] = nums2[j]; // 插入
                    j++; // nums2 指针后移
                }
                i++; // nums1 指针后移
            } else if (nums1[i] > nums2[j]) {
                for (int k = m + j; k > i; k--) {
                    nums1[k] = nums1[k - 1]; // nums1 中有效数据后移
                }
                nums1[i] = nums2[j]; // 插入
                j++; // nums2 指针后移
            }
        }
        return nums1;
    }

    public static void main(String[] args) {

        System.out.println("请输入两个数组：");
        Scanner sc = new Scanner(System.in);

        System.out.print("nums1=");
        String s1 = sc.nextLine();
        s1 = s1.substring(1, s1.length() - 1);
        String[] n1 = s1.split(",");
        int[] nums1 = new int[n1.length];
        for (int i = 0; i < n1.length; i++) {
            nums1[i] = Integer.parseInt(n1[i]);
        }
        System.out.print("nums2=");
        String s2 = sc.nextLine();
        s2 = s2.substring(1, s2.length() - 1);
        String[] n2 = s2.split(",");
        int[] nums2 = new int[n2.length];
        for (int i = 0; i < n2.length; i++) {
            nums2[i] = Integer.parseInt(n2[i]);
        }

        System.out.println(Arrays.toString(solution(nums1, nums1.length - nums2.length, nums2, nums2.length)));
    }
}
