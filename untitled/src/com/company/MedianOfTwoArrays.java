/**
 * @author: Wxj
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 num1 和 num2。请你找出并返回这两个正序数组的 中位数。
 * <p>输入描述:
 * nums1 = [1,3]
 * nums2 = [2]
 * <p>输出描述:
 * 2.0
 */
package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MedianOfTwoArrays {


    // 硬着头皮遍历
    public static double solution1(int[] num1, int[] num2) {
        int n1 = num1.length;
        int n2 = num2.length;
        int n = n1 + n2;
        int[] num = new int[n]; //初始化合并的新数组

        //num1为空时只考虑num2
        if (n1 == 0 && n2 != 0) {
            if (n2 % 2 == 0) {
                return (num2[n2 / 2 - 1] + num2[(n2 / 2)]) / 2.0; //偶
            } else {
                return num2[(n2 - 1) / 2]; //奇
            }
        }

        //num2为空时只考虑num1
        if (n1 != 0 && n2 == 0) {
            if (n1 % 2 == 0) {
                return (num1[n1 / 2 - 1] + num1[(n1 / 2)]) / 2.0;
            } else {
                return num1[(n1 - 1) / 2];
            }
        }

        //num1和num2均不为空合并新数组
        if (n1 != 0 && n2 != 0) {
            System.arraycopy(num1, 0, num, 0, n1);
            System.arraycopy(num2, 0, num, 0 + n1, n2); //合并新数组
            Arrays.sort(num); //重新排序

            if (n % 2 == 0) {
                return (num[n / 2 - 1] + num[(n / 2)]) / 2.0;
            } else {
                return num[(n - 1) / 2];
            }
        }
        return 0;
    }

    // 二分法
    public static double solution2(int[] num1, int[] num2) {
        int n1 = num1.length;
        int n2 = num2.length;
        int left = (n1 + n2 + 1) / 2;
        int right = (n1 + n2 + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的k。
        return (getKth(num1, 0, n1 - 1, num2, 0, n2 - 1, left) + getKth(num1, 0, n1 - 1, num2, 0, n2 - 1, right)) * 0.5;
    }

    private static int getKth(int[] num1, int start1, int end1, int[] num2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让len1的长度小于len2，这样就能保证如果有数组空了，一定是len1
        if (len1 > len2) return getKth(num2, start2, end2, num1, start1, end1, k);
        //len1=0只需考虑num2，返回num2的第k个元素
        if (len1 == 0) return num2[start2 + k - 1];
        //k=1返回num1和num2起始元素中更小的元素
        if (k == 1) return Math.min(num1[start1], num2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        //递归
        if (num1[i] > num2[j]) {
            return getKth(num1, start1, end1, num2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(num1, i + 1, end1, num2, start2, end2, k - (i - start1 + 1));
        }
    }

    //输入处理
    public static int[] input(String s) {
        if (s.length() > 2) {
            String str = s.substring(1, s.length() - 1); //去掉首尾[]
            String[] arr = str.split(","); //按,分隔
            int[] nums = new int[arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(arr[i]); //string强制转换成int型
            }
            return nums;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("num1=");
        String s1 = sc.nextLine();
        int[] num1 = input(s1);
        System.out.print("num2=");
        String s2 = sc.nextLine();
        int[] num2 = input(s2);
        System.out.println(solution1(num1, num2));
        System.out.println(solution2(num1, num2));
    }
}

